package com.appgate.substr.finder;

import java.util.ArrayList;
import java.util.List;

public class FindPositions {

    public static List<List<Integer>> findPositions(final int indexInit, final String s, final String t) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> setOfindex = new ArrayList<>();
        setOfindex.add(indexInit);
        res.add(setOfindex);

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int j = 1; j < tArray.length; j++) {
            setOfindex = new ArrayList<>();
            for (int i = indexInit; i < sArray.length; i++) {
                if (sArray[i] == tArray[j]) {
                    setOfindex.add(i);
                }
            }
            res.add(setOfindex);
        }

        return res;

    }
}
