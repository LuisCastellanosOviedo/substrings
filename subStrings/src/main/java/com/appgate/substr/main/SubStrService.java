package com.appgate.substr.main;

import com.appgate.substr.definition.SubStrDefinition;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

import static com.appgate.substr.finder.FindIndexFirstLetter.buildIndexsPivote;
import static com.appgate.substr.finder.function.catalog.SubStrFunctionCatalog.findFirstIndexCharAtStrategy;
import static com.appgate.substr.main.DefaultCombinator.findAllpossibleCombinations;

@Component
@Primary
@Log4j2
public class SubStrService implements SubStrDefinition {


    public int execute(final String s, final String t) {
        int combinations = 0;

        Optional<Integer> basicCasesValidation = validateBasicCases(s, t);

        if (!basicCasesValidation.isPresent()) {
            List<Integer> firstLetterPositions = findIndexWhereFirstLetterIsPresent(s, t,findFirstIndexCharAtStrategy);
            combinations = findAllpossibleCombinations(s, t, firstLetterPositions).size();
        }

        return basicCasesValidation.orElse(combinations);
    }

    private Optional<Integer> validateBasicCases(final String s, final String t) {
        Optional<Integer> basicCase = Optional.empty();

        if (s.isEmpty() && t.isEmpty()) {
            basicCase = Optional.of(0);
        } else if (s.equals(t)) {
            basicCase = Optional.of(1);
        }

        return basicCase;
    }


    private List<Integer> findIndexWhereFirstLetterIsPresent(final String s, final String t,
                                                             final BiFunction<String,String, List<Integer>> findIndexesForFirstLetter) {
        List<Integer> firstLetterPositions = new ArrayList<>();
        try {
            firstLetterPositions = buildIndexsPivote(s, t,findIndexesForFirstLetter);
        } catch (ExecutionException e) {
            log.error("Error running subStr ");
        } catch (InterruptedException e) {
            log.error("Error running parallel execution");
        }
        return firstLetterPositions;
    }
}
