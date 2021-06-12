package co.com.refactor.analyzer;

import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.model.SocialMention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class AnalyzerFactory {

    private final Set<Analyzer> analizers;

    @Autowired
    public AnalyzerFactory(Set<Analyzer> analizers) {
        this.analizers = analizers;
    }

    public Optional<Analyzer> getAnalyzer(SocialMention socialMention) {
        return analizers.stream().filter(x -> x.getType(socialMention)).findFirst();
    }
}
