package co.com.refactor.analyzer;

import co.com.refactor.SocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class AnalyzerFactory {

    @Autowired
    private Set<Analyzer> analizers;


    public Optional<Analyzer> getAnalyzer(SocialMention socialMention){
       return analizers.stream().filter(x -> x.getType(socialMention)).findFirst();
    }
}
