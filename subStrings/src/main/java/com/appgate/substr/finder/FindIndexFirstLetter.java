package com.appgate.substr.finder;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;

public class FindIndexFirstLetter {

    public static List<Integer> buildIndexsPivote(String s, String t,
                                                  BiFunction<String,String, List<Integer>> findIndexesForFirstLetter)
            throws ExecutionException, InterruptedException {

        ForkJoinPool customThreadPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        List<Integer> pivotList;
        try {
            pivotList = customThreadPool.submit(() ->
                    findIndexesForFirstLetter.apply(s, t))
                    .get();
        } finally {
            customThreadPool.shutdown();
        }

        return pivotList;

    }


}
