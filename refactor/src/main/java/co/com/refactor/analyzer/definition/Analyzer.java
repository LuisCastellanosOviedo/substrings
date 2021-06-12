package co.com.refactor.analyzer.definition;

import co.com.refactor.model.SocialMention;
import co.com.refactor.analyzer.domain.AnalyzerResponse;

public interface Analyzer {

    AnalyzerResponse analyze(SocialMention socialMention);

    Boolean getType(SocialMention socialMention);

}
