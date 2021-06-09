package com.appgate.substr.finder;

import java.util.ArrayList;
import java.util.List;

public class FindIndexFirstLetter {

    public static List<Integer> buildIndexsPivote(String s, String t){

        List<Integer> pivotList = new ArrayList<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i) == t.charAt(0)){
                pivotList.add(i);
            }
        }
        return pivotList;

    }


}
