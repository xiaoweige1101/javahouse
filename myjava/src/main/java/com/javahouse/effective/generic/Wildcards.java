package com.javahouse.effective.generic;

public class Wildcards {

    // 这里Holder等价于Holder<Object>，Holder<Object>没警告但下面的方法调用时除第一个都会报ERROR，Holder会有警告
    static void saveData(Holder holder, Object arg) {
        holder.set(arg); // [Warning] Type safety: The method set(Object) belongs to the raw type Holder. References to generic type Holder<T> should be parameterized
        Object obj = holder.get();
        System.out.println(obj.getClass().getSimpleName() + ": " + obj.toString());
    }

    // 因为不知道Holder<?>的具体类型是什么，所以我们就不允许往里set数据
    static void saveDataError(Holder<?> holder, Object arg) {
        // holder.set(arg); // [Compile Error] The method set(capture#1-of ?) in the type Holder<capture#1-of ?> is not applicable for the arguments (Object)
        // holder.set(new Wildcards()); // Same Compile Error
        Object obj = holder.get();
        System.out.println(obj.getClass().getSimpleName() + ": " + obj.toString());
    }

    public static void main(String[] args) {
        Holder h1 = new Holder<Long>();
        Holder<Long> h2 = new Holder<Long>();
        Holder<?> h3 = new Holder<Long>();
        Holder<? extends Long> h4 = new Holder<Long>();

//        h3.set(1);

        saveData(h1, 1L); // Long: 1
        saveData(h2, 2L); // Long: 2
        saveData(h3, 3L); // Long: 3
        saveData(h4, 4L); // Long: 4

        saveDataError(h1, 5L); // Long: 1
        saveDataError(h2, 6L); // Long: 2
        saveDataError(h3, 7L); // Long: 3
        saveDataError(h4, 8L); // Long: 4
    }
}

class Holder<T> {
    private T value;
    public Holder() { }
    public Holder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
    @Override public boolean equals(Object obj) { return value.equals(obj); }
}
