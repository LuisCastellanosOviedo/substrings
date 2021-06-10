package com.appgate.substr.finder.function.catalog;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubStrFunctionCatalog {

    public static BiFunction<String, String, List<Integer>> findFirstIndexCharAtStrategy = (x, y) ->
            IntStream
                    .range(0, x.toCharArray().length)
                    .parallel()
                    .filter(z -> x.toCharArray()[z] == y.charAt(0))
                    .mapToObj(i -> i)
                    .collect(Collectors.toList());

}
