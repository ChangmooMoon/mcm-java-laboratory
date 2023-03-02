package org.example.ch4_Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.example.ch4_Stream.VO.Dish;
import org.example.ch4_Stream.VO.Dish.Type;

public class main {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("fries", true, 500, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", false, 600, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        var lowCaloricDishes = menu.stream()
            .filter(d -> d.getCalories() < 400)
            .sorted(comparing(Dish::getCalories))
            .map(Dish::getName)
            .limit(3)
            .collect(toList());
        System.out.println(lowCaloricDishes);

        Map<Type, List<Dish>> dishesByType = menu.stream()
            .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }
}
