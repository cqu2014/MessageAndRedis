package com.oliver.guava.approach;

import java.util.Optional;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/16
 * @Since
 */
public class JavaOptional {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(10);
        filter(optional);
        map(optional);
        orElse(100,optional);

        Optional<Integer> secondOptional = Optional.ofNullable(null);

        System.out.println(optional.equals(secondOptional));
        System.out.println(Optional.empty().equals(secondOptional));
        System.out.println(secondOptional.toString());
        System.out.println(optional.toString());

        System.out.println(optional.flatMap(x -> Optional.of(x * 3)).toString());
    }

    public static void filter(Optional<Integer> optionalT){
        System.out.println(optionalT.filter(x -> x < 11)
                .isPresent());
    }

    public static void map(Optional<Integer> optional){
        System.out.println(optional.map(x -> x * x)
                .get());
    }

    public static void orElse(Integer var,Optional<Integer> optional){
        System.out.println(optional.orElse(var));
    }
}
