package com.appgate.substr.combiner;

import java.util.ArrayList;
import java.util.List;

public class CombinerAsc {

    public static List<List<Integer>> combine(List<List<Integer>> a, List<Integer> b) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> subCombination = a.get(i);
            int subCombinationSize = subCombination.size();
            for (int j = 0; j < b.size(); j++) {
                int newElementForCombinator = b.get(j);
                if (subCombination.get(subCombinationSize - 1) < newElementForCombinator) {
                    List<Integer> a1 = new ArrayList<>(subCombination);
                    a1.add(newElementForCombinator);
                    res.add(a1);
                }
            }
        }

        return res;
    }
}
