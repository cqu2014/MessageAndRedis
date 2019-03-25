package com.oliver.guava.test;

import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;

/**
 * @Author Oliver Wang
 * @Description Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。
 *          它检查的先决条件。其方法失败抛出IllegalArgumentException
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/20
 * @Since
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        PreconditionsTest preconditionsTest = BeanUtils.instantiateClass(PreconditionsTest.class);
        preconditionsTest.checkArgument(10);

        String name = "";

        Preconditions.checkNotNull(name,"name must not be null");

        Preconditions.checkElementIndex(10,11,"越界了");
    }

    private void checkArgument(int age){
        Preconditions.checkArgument(age>0 && age < 200,"输入年龄非法");
    }
}
