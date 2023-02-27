package org.example.ch2_behavior_parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class main2 {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = List.of(new Apple(Color.GREEN, 151), new Apple(Color.RED
            , 151), new Apple(Color.GREEN, 159));

//        List<Apple> result = filterApples(inventory, new AppleGreenColorAndWeightOver150Predicate());
//        System.out.println(result);

//        List<Apple> result2 = filterApples(inventory, new ApplePredicate() {
//            @Override
//            public boolean test(final Apple apple) {
//                return Color.RED.equals(apple.getColor());
//            }
//        });

//        List<Apple> result3 = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        List<Integer> evenNums = filter(List.of(1, 2, 3, 4, 5, 6), (Integer i) -> i % 2 == 0);
        System.out.println(evenNums);
    }
}
