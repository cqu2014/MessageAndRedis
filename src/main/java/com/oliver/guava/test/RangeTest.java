package com.oliver.guava.test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

/**
 * @Author Oliver Wang
 * @Description Range 表示一个间隔或一个序列
 * 它被用于获取一组数字/串在一个特定范围之内
 * @Created by IntelliJ IDEA 2018.3.3
 * @Date Create at 2019/3/21
 * @Since
 */
public class RangeTest {
    public static void main(String[] args) {
        System.out.println(Range.all());
        System.out.println(Range.closed(1, 10));
        System.out.println(Range.closedOpen(1, 10));
        System.out.println(Range.openClosed(1, 10));
        System.out.println(Range.atLeast(5));
        System.out.println(Range.atMost(100));
        System.out.println(Range.open(1, 2));
        System.out.println(Range.closed(1, 1).contains(1));
        System.out.println("------------------------------------------------");
        System.out.println(Range.downTo(4, BoundType.OPEN));
        System.out.println(Range.upTo(4, BoundType.CLOSED));
        System.out.println(Range.range(1, BoundType.OPEN, 4, BoundType.CLOSED));
        System.out.println("-----------------------------------------------------");
        System.out.println(Range.closedOpen(1, 3).contains(2));
        System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 5)));
        System.out.println("-----------------isEmpty--------------------");
        Range<Integer> fourToFour = Range.closedOpen(4, 4);
        System.out.println(fourToFour.hasLowerBound());
        System.out.println(fourToFour.hasUpperBound());
        System.out.println(fourToFour.isEmpty());
        System.out.println("-------------------Endpoint端点值---------------------------");
        Range<Integer> three = Range.closedOpen(3, 10);
        System.out.println(three.lowerEndpoint());
        System.out.println(three.upperEndpoint());
        System.out.println(three.lowerBoundType());
        System.out.println(three.upperBoundType());
        System.out.println("-----------------------------------------------------------");
        /**
         * encloses(Range range)中的range是否包含在需要比较的range中
         */
        Range<Integer> rangeBase = Range.open(1, 4);
        Range<Integer> rangClosed = Range.closed(2, 3);
        Range<Integer> rangeCloseOpen = Range.closedOpen(2, 4);
        Range<Integer> rangeCloseOther = Range.closedOpen(2, 5);

        System.out.println(rangeBase.encloses(rangClosed));
        System.out.println(rangeBase.encloses(rangeCloseOpen));
        System.out.println(rangeBase.encloses(rangeCloseOther));
        System.out.println("----------------------------------------");
        /**
         * isConnected：range是否可连接上,是否同时被两个序列包含的序列（可以是空序列）
         */
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).isConnected(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).isConnected(Range.closed(6, 10)));
        System.out.println("-------------------------------------");
        /**
         * intersection：如果两个range相连时，返回最大交集，如果不相连时，直接抛出异常
         */
        System.out.println(Range.closed(3, 5).intersection(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).intersection(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).intersection(Range.closed(3, 9)));
        //System.out.println(Range.open(3, 5).intersection(Range.open(5, 10)));
        //System.out.println(Range.closed(1, 5).intersection(Range.closed(6, 10)));
        System.out.println("-------------------------------------");
        /**
         * span：获取两个range的并集，如果两个range是两连的，则是其最大range
         */
        System.out.println(Range.closed(3, 5).span(Range.open(5, 10)));
        System.out.println(Range.closed(0, 9).span(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).span(Range.closed(3, 9)));
        System.out.println(Range.open(3, 5).span(Range.open(5, 10)));
        System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));
        System.out.println(Range.closed(1, 5).span(Range.closed(7, 10)));
    }
}
