package co.com.refactor.analyzer;

import co.com.refactor.SocialMention;
import co.com.refactor.TwitterSocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.dto.risk.RiskDto;
import co.com.refactor.analyzer.risks.DefaultRiskDefinition;
import co.com.refactor.analyzer.services.FacebookScoreService;
import co.com.refactor.dataaccess.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static co.com.refactor.SocialMentionController.ANALYZED_TWEETS_TABLE;
import static java.util.Objects.isNull;

@Component
public class TwitterAnalyzer implements Analyzer {

    @Autowired
    private DBService dbService;

    @Autowired
    private TweeterAnalyzerDelegate tweeterAnalyzerDelegate;

    @Autowired
    @Qualifier("twitterRisk")
    private DefaultRiskDefinition defaultRiskDefinition;

    @Autowired
    private FacebookScoreService facebookScoreService;

    @Override
    public AnalyzerResponse analyze(final SocialMention socialMention) {
        Double tweeterScore = 0d;
        Double facebookScore = 0d;
        TwitterSocialMention twitterSocialMention = socialMention.getTwitterSocialMention();
        AnalyzerResponse analyzerResponse = new AnalyzerResponse();

        analyzerResponse.setMessage("tweeterMessage: " + twitterSocialMention.getMessage());

        tweeterScore = tweeterAnalyzerDelegate.analyzeTweet(analyzerResponse.getMessage(),
                twitterSocialMention.getTweeterUrl(), twitterSocialMention.getTweeterAccount());

        dbService.insertTweet(ANALYZED_TWEETS_TABLE, tweeterScore, analyzerResponse.getMessage(),
                twitterSocialMention.getTweeterUrl(), twitterSocialMention.getTweeterAccount());

        facebookScore = facebookScoreService
                .defineScore(analyzerResponse.getMessage(), socialMention.getFacebookSocialMention().getFacebookAccount());

        analyzerResponse.setMessage(defaultRiskDefinition.defineRiskLevel(RiskDto.builder().facebookScore(facebookScore)
                .tweeterScore(tweeterScore).build()));
        return analyzerResponse;
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return !isNull(socialMention.getTwitterSocialMention()) &&
                !isNull(socialMention.getTwitterSocialMention().getTweeterAccount());
    }
}
