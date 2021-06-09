package com.appgate.substr.finder;

import java.util.ArrayList;
import java.util.List;

public class FindPositions {

    public static List<List<Integer>> findPositions(int indexInit, String s, String t) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> setOfindex = new ArrayList<>();
        setOfindex.add(indexInit);
        res.add(setOfindex);


        for (int j = 1; j < t.toCharArray().length; j++) {
            setOfindex = new ArrayList<>();
            for (int i = indexInit; i < s.toCharArray().length; i++) {
                if (s.toCharArray()[i] == t.toCharArray()[j]) {
                    setOfindex.add(i);
                }
            }
            res.add(setOfindex);
        }

        return res;

    }
}
