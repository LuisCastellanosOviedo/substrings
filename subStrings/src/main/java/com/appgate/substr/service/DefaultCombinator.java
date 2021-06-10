package com.appgate.substr.service;

import java.util.ArrayList;
import java.util.List;

import static com.appgate.substr.combiner.CombinerAsc.combine;
import static com.appgate.substr.finder.FindPositions.findPositions;

public class DefaultCombinator {

    public static List<List<Integer>> findAllpossibleCombinations(String s, String t, List<Integer> firstLetterPositions) {
        List<List<Integer>> combinator = new ArrayList<>();
        for (Integer firstLetterPosition : firstLetterPositions) {
            List<List<Integer>> positionPerLetter = findPositions(firstLetterPosition, s, t);
            List<List<Integer>> comb = combGenerator(positionPerLetter);
            combinator.addAll(comb);
        }

        return combinator;
    }

    private static List<List<Integer>> combGenerator(List<List<Integer>> positionPerLetter) {
        List<List<Integer>> comb = new ArrayList<>();
        comb.add(positionPerLetter.get(0));
        for (int i = 1; i < positionPerLetter.size(); i++) {
            comb = combine(comb, positionPerLetter.get(i));
        }
        return comb;
    }
}
