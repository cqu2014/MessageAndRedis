package com.oliver.guava.test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @Author Oliver Wang
 * @Description 通过类型获取value值
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class ClassToInstanceMapTest {
    public static void main(String[] args) {
        ClassToInstanceMap<Number> numberClassToInstanceMap = MutableClassToInstanceMap.create();
        numberClassToInstanceMap.put(Integer.class, 0);
        numberClassToInstanceMap.put(int.class,100);
        System.out.println(numberClassToInstanceMap.getInstance(Integer.class));
        //父类型亦获取不到子类型对应的值
        System.out.println(numberClassToInstanceMap.getInstance(Number.class));
        System.out.println(numberClassToInstanceMap.getInstance(Double.class));
        //一个原生类型和他的相应的包装类可以映射到不同的值
        System.out.println(numberClassToInstanceMap.getInstance(int.class));
        System.out.println("------------------------------------------------");

        System.out.println(numberClassToInstanceMap.get(int.class));
        numberClassToInstanceMap.put(long.class,123456L);
        System.out.println("-------------------------------------------------");

        ClassToInstanceMap<String> classToInstanceMapString = MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();

        Person person = new Person("Oliver",28);
        System.out.println(person.toString());
        classToInstanceMapString.put(String.class,"Oliver");
        System.out.println("String: "+classToInstanceMapString.getInstance(String.class));
        System.out.println("-------------------------------------------");
        classToInstanceMap.put(Person.class,person);
        Person person1 = classToInstanceMap.getInstance(Person.class);
        System.out.println("person1: "+person1);
        System.out.println("------------------------------");

        System.out.println(classToInstanceMap);
        System.out.println(classToInstanceMapString);



    }
}

    @AllArgsConstructor
    @ToString
    class Person {
        public String name;
        public int age;
    }
