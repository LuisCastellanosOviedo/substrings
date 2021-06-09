package com.appgate.substr.main;

import com.appgate.substr.combiner.CombinerAsc;
import com.appgate.substr.definition.SubStrDefinition;
import com.appgate.substr.finder.FindPositions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.appgate.substr.finder.FindIndexFirstLetter.buildIndexsPivote;

@Component
@Primary
public class SubStrService implements SubStrDefinition {


    public int execute(String s, String t) {

        if(s.isEmpty() && t.isEmpty()){
            return 0;
        }
        if(s.equals(t)){
            return 1;
        }


        List<Integer> firstLetterPositions = buildIndexsPivote(s, t);
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

        return combinatory.size();
    }
}
