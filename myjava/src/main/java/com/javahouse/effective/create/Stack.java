package com.javahouse.effective.create;

public class Stack {
    private Object[] elements;

    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
// 我们不一定将elements.clone()的结果转换成Object[]。
// 自Java1.5发行版起，在数组上调用clone返回数组的数组，其编译时类型与被克隆数组的类型相同
// 注：如果elements域是final的，上述方案就不能正常工作，因为clone方法是被禁止给elements域赋新值
// (clone架构与引用可变对象的final域的正常使用时不兼容的)
