package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;


public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().allMatch((text -> Character.isUpperCase(text.charAt(0))));
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            x.addAll(x.stream().filter(number -> number % 2 == 0).collect(Collectors.toList()));
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> newValues = new ArrayList<>();
            for (String value : values) {
                int count = 0;
                for (Character c : value.toCharArray()) {
                    if (c == ' ') {
                        count++;
                    }
                }
                boolean check = Character.isUpperCase(value.charAt(0));
                if (value.endsWith(".")
                        && check
                        && count > 2) {
                    newValues.add(value);
                }
            }
            return newValues;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(String::valueOf, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list1);
            newList.addAll(list2);
            return newList;
        };
    }
}
