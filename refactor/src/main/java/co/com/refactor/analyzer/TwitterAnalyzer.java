package co.com.refactor.analyzer;

import co.com.refactor.analyzer.delegate.twitter.TweeterAnalyzerDelegate;
import co.com.refactor.model.SocialMention;
import co.com.refactor.model.TwitterSocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.risks.dto.RiskDto;
import co.com.refactor.analyzer.risks.definition.DefaultRiskDefinition;
import co.com.refactor.analyzer.services.FacebookScoreService;
import co.com.refactor.dataaccess.TwitterDBService;
import co.com.refactor.dataaccess.dbmodel.TwitterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class TwitterAnalyzer implements Analyzer {


    private static final String TWEETER_MESSAGE_HEADER = "tweeterMessage: ";

    private final TwitterDBService twitterDBService;

    private final TweeterAnalyzerDelegate tweeterAnalyzerDelegate;

    private final DefaultRiskDefinition defaultRiskDefinition;

    private final FacebookScoreService facebookScoreService;

    @Autowired
    public TwitterAnalyzer(TwitterDBService twitterDBService, TweeterAnalyzerDelegate tweeterAnalyzerDelegate,
                           @Qualifier("twitterRisk") DefaultRiskDefinition defaultRiskDefinition, FacebookScoreService facebookScoreService) {
        this.twitterDBService = twitterDBService;
        this.tweeterAnalyzerDelegate = tweeterAnalyzerDelegate;
        this.defaultRiskDefinition = defaultRiskDefinition;
        this.facebookScoreService = facebookScoreService;
    }

    @Override
    public AnalyzerResponse analyze(final SocialMention socialMention) {
        TwitterSocialMention twitterSocialMention = socialMention.getTwitterSocialMention();
        AnalyzerResponse analyzerResponse = new AnalyzerResponse();

        analyzerResponse.setMessage(TWEETER_MESSAGE_HEADER + twitterSocialMention.getMessage());

        Double tweeterScore = tweeterAnalyzerDelegate.analyzeTweet(analyzerResponse.getMessage(), twitterSocialMention.getTweeterUrl(),
                twitterSocialMention.getTweeterAccount());

        TwitterEntity twitterEntity = new TwitterEntity( tweeterScore, analyzerResponse.getMessage(),
                twitterSocialMention.getTweeterUrl(), twitterSocialMention.getTweeterAccount());

        twitterDBService.insertTweet(twitterEntity);

        Double facebookScore = facebookScoreService.defineScore(analyzerResponse.getMessage(), socialMention.getFacebookSocialMention().getFacebookAccount());

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
