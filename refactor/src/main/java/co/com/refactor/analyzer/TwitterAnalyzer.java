package co.com.refactor.analyzer;

import co.com.refactor.SocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.dto.SocialMediaData;
import org.springframework.stereotype.Component;

@Component
public class TwitterAnalyzer implements Analyzer {

    @Override
    public AnalyzerResponse analyze(SocialMediaData socialMediaData) {
        return null;
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return socialMention.getTweeterAccount() != null;
    }
}
