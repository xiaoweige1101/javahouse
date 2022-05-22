package com.javahouse.jdk.stream;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {


    /**
     * 1 将集合作为数据源，读取集合中的数据到一个流中
     */
    @Test
    public void createStream01() {
        // 1. 实例化一个集合
        List<Integer> list = new ArrayList<>();
        // 2. 填充元素
        Collections.addAll(list, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 3. 读取集合中的数据，将其读取到顺序流中
        // Stream<Integer> stream = list.stream();
        // 3. 读取集合中的数据，将其读取到并行流中
        Stream<Integer> stream = list.parallelStream();
        // 4. 输出stream
        System.out.println(stream);
    }


    /**
     * 2 将数组作为数据源，读取数组中的数据到一个流中
     */
    @Test
    public void createStream02() {
        // 1. 实例化一个数组
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 2. 读取数组中的数据，将其读取到流中
        Stream<Integer> stream = Arrays.stream(array);
        // 3. 输出stream
        System.out.println(stream);
    }


    /**
     * 3 使用静态方法Stream.of()，通过显式值创建一个流
     */
    @Test
    public void createStream03() {
        Stream<Integer> stream = Stream.of(0, 1, 3, 5, 7, 9);
    }

    /**
     * 4 由函数创建，创建无限流
     */
    public void createStream04() {
        Stream.generate(Math::random).limit(5).forEach(System.out::print);
        List<Integer> collect = Stream.iterate(0,i -> i + 1).limit(5).collect(Collectors.toList());
    }

    /**
     * 学生类： 存储于集合中的数据的类型
     */
    private static class Student implements Comparable<Student> {
        private String name;
        private int age;
        private int score;

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    score == student.score &&
                    Objects.equals(name, student.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age, score);
        }
        @Override
        public int compareTo(Student o) {
            return score - o.score;
        }
    }

    /**
     * 读取数据源，将集合中存储的数据读取到数据源中
     * @return 流
     */
    public static Stream<Student> getDataSource() {
        // 1. 实例化一个集合，存Student对象
        List<Student> list = new ArrayList<>();
        // 2. 添加若干数据
        Collections.addAll(list,
                new Student("xiaoming",17,90),
                new Student("xiaohong",18,100),
                new Student("xiaohong",21,100),
                new Student("xiaolan",18,90),
                new Student("xiaoli",19,68),
                new Student("xiaobai",18,72),
                new Student("xiaohei",20,39),
                new Student("xiaoke",17,93),
                new Student("xiaoqing",19,79),
                new Student("xiaofei",18,56)
        );

        // 3. 读取数据源，得到Stream对象
        return list.stream();
    }

    /**
     * 中间操作： filter 条件过滤
     * 可以将流中满足指定条件的数据保留，去掉不满足指定条件的数据
     */
    @Test
    public void testFilter() {
        // 1. 获取数据源
        Stream<Student> dataSource = getDataSource();
        // 2. 过滤掉集合中成绩不及格的学生信息
        dataSource.filter(s -> s.getScore() >= 60).forEach(System.out::println);
    }


    /**
     * 中间操作：distinct
     * 去重，去除流中的重复的数据，这个方法是没有参数的，去重的规则与hashSet相同
     * 1. 比较两个对象的hashCode
     * 2. 再比较两个对象的equals
     */
    @Test
    public void testDistinct() {
        // 1. 获取数据源
        Stream<Student> dataSource = getDataSource();
        // 2. 去重
        dataSource.distinct().forEach(System.out::println);
    }


    /**
     * 中间操作： sorted
     * sorted(): 将流中的数据，按照其对应的类实现的Comparable接口提供的比较规则进行排序
     * sorted(Comparator comparator): 将流中的数据按照参数接口提供的比较规则进行排序
     */
    @Test
    public void testSorted() {
        // 1. 获取数据源
        Stream<Student> dataSource = getDataSource();
        // 2. 对流中的数据进行排序
        // dataSource.sorted().forEach(System.out::println);
        // 3. 对流中的数据按照自定义的规则进行排序
        dataSource.sorted((s1,s2) -> s1.age - s2.age).forEach(System.out::println);
    }

    /**
     * 中间操作： limit & skip
     * limit: 限制，表示截取流中的指定数量的数据（从第 0 开始），丢弃剩余部分
     * skip: 跳过，表示跳过指定数量的数据，截取剩余部分
     */
    @Test
    public void testLimit() {
        // 1. 获取数据源
        Stream<Student> dataSource = getDataSource();
        // 2. 获取成绩的[3,5]名
        dataSource.sorted((s1,s2) -> s2.score - s1.score).distinct()
                .limit(5)
                .skip(2)
                .forEach(System.out::println);
    }

    /**
     * 中间操作： map
     * 元素映射，提供一个映射规则，将流中的每一个元素替换成指定的元素
     * map: 对流中的数据进行映射，用新的数据替换旧的数据
     */
    @Test
    public void testMap() {
        // 1. 获取数据源
        Stream<Student> dataSource = getDataSource();
        // 2. 实际需求： 获取所有学生的名字
        dataSource.map(Student::getName)
                .forEach(System.out::println);
//        dataSource.map(s -> s.getName()).forEach(System.out::println);
        // 3. 实际需求： 获取所有学生的成绩
        // 这里，会得到 Stream<Integer>
//         dataSource.map(Student::getScore).forEach(System.out::println);
        // 4. 实际需求： 获取所有的学生成绩
        IntSummaryStatistics intSummaryStatistics = dataSource.mapToInt(Student::getScore).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
    }


    /**
     * 中间操作：flatMap
     * 扁平化映射： 一般是用在map映射完成后，流中的数据是一个容器，而我们需要再对容器中的数据进行处理,此时使用扁平化映射，可以将流中的容器中的数据，直接读取到流中
     */
    @Test
    public void testFlatMap() {
        // 1. 实例化一个字符串数组
        String[] s = new String[]{ "hello","world"};
        // 2. 将字符串数组中的数据读取到流中
        Stream<String> stream = Arrays.stream(s);

        // 3. 需求： 统计字符串数组中所有出现的字符
        stream.map(e -> e.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);
    }

/*
    public static Stream<Integer> getDataSource() {
        // 1. 准备一个容器
        List<Integer> datasource = new ArrayList<>();
        // 2. 向数据中添加数据
        Collections.addAll(datasource,0,1,2,3,4,5,6,7,8,9);
        // 3. 读取数据源中的数据，得到Stream对象并返回
        return datasource.stream();
    }
*/


}