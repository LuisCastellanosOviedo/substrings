package com.appgate.substr.function;

import com.appgate.substr.definition.SubStrDefinition;
import com.appgate.substr.model.CombinatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component(value = "func-logic")
public class SubStrFunction  implements Function<CombinatorRequest, Integer> {

    @Autowired
    private SubStrDefinition subStrDefinition;

    @Override
    public Integer apply(CombinatorRequest combinatorRequest) {
       return  subStrDefinition.execute(combinatorRequest.getS(),combinatorRequest.getT());
    }
}
