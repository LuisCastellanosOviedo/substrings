package co.com.refactor.analyzer.definition;

import co.com.refactor.SocialMention;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.dto.SocialMediaData;

public interface Analyzer {

    AnalyzerResponse analyze(SocialMention socialMention);

    Boolean getType(SocialMention socialMention);

}
