package co.com.refactor.analyzer;

import co.com.refactor.SocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.dto.SocialMediaData;
import org.springframework.stereotype.Component;

@Component
public class FacebookAnalyzer implements Analyzer {

    @Override
    public AnalyzerResponse analyze(SocialMediaData socialMediaData) {

        socialMention.setMessage("facebookMessage: " + socialMention.getMessage());
        String comments = socialMention.getFacebookComments()
                .stream().reduce("", (h, c) -> h + " " + c);
        socialMention.setMessage(socialMention.getMessage() + " || comments: " + comments);

        return null;
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return socialMention.getFacebookAccount() != null;
    }
}
