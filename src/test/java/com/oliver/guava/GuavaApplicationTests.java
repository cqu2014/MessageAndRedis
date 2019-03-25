package com.oliver.guava;

import com.google.common.base.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuavaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void useOption() {
        Optional<Integer> optional = Optional.absent();

        System.out.println(optional.get());
    }


    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("a = " + a.get());
        System.out.println("b = " + b.get());

        Integer var1 = a.get();

        return var1 + b.get();
    }

}
