package com.appgate.substr.combiner;

import java.util.ArrayList;
import java.util.List;

public class CombinerAsc {

    public static List<List<Integer>> combine(List<List<Integer>> a , List<Integer> b){

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if(a.get(i).get(a.get(i).size()-1)< b.get(j)){
                    List<Integer> a1 = new ArrayList<>(a.get(i));

                    a1.add(b.get(j));
                    res.add(a1);
                }
            }
        }

        return res;
    }
}
