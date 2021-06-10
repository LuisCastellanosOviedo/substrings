package com.appgate.substr.main;

import com.appgate.substr.combiner.CombinerAsc;
import com.appgate.substr.finder.FindPositions;

import java.util.ArrayList;
import java.util.List;

public class DefaultCombinator {

    public static List<List<Integer>> findAllpossibleCombinations(String s, String t, List<Integer> firstLetterPositions) {
        List<List<Integer>> combinatory = new ArrayList<>();
        for (Integer firstLetterPosition : firstLetterPositions) {
            List<List<Integer>> positionPerLetter = FindPositions.findPositions(firstLetterPosition, s, t);
            List<List<Integer>> comb = new ArrayList<>();
            comb.add(positionPerLetter.get(0));
            for (int i = 1; i < positionPerLetter.size(); i++) {
                comb = CombinerAsc.combine(comb, positionPerLetter.get(i));
            }
            combinatory.addAll(comb);
        }

        return combinatory;
    }
}
