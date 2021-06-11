package co.com.refactor.analyzer;

import co.com.refactor.SocialMention;
import co.com.refactor.TwitterSocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.dto.SocialMediaData;
import co.com.refactor.dataaccess.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static co.com.refactor.SocialMentionController.ANALYZED_TWEETS_TABLE;
import static java.util.Objects.isNull;

@Component
public class TwitterAnalyzer implements Analyzer {

    @Autowired
    private DBService dbService;

    @Autowired
    private TweeterAnalyzerDelegate tweeterAnalyzerDelegate;

    @Override
    public AnalyzerResponse analyze(SocialMention socialMention) {
        Double tweeterScore = 0d;
        Double facebookScore = 0d;
        TwitterSocialMention twitterSocialMention = socialMention.getTwitterSocialMention();
        AnalyzerResponse analyzerResponse = new AnalyzerResponse();

        analyzerResponse.setMessage("tweeterMessage: " + twitterSocialMention.getMessage());


        tweeterScore = tweeterAnalyzerDelegate.analyzeTweet(analyzerResponse.getMessage(), twitterSocialMention.getTweeterUrl(), twitterSocialMention.getTweeterAccount());
        dbService.insertTweet(ANALYZED_TWEETS_TABLE, tweeterScore, analyzerResponse.getMessage(), twitterSocialMention.getTweeterUrl(), twitterSocialMention.getTweeterAccount());


        if (tweeterScore >= -1 && tweeterScore <= -0.5d) {
            analyzerResponse.setMessage("HIGH_RISK");
        } else if (tweeterScore > -0.5d && tweeterScore < 0.7d) {
            analyzerResponse.setMessage("MEDIUM_RISK");
        } else if (facebookScore >= 0.7d) {
            analyzerResponse.setMessage("LOW_RISK");
        }


        return analyzerResponse;
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return !isNull(socialMention.getTwitterSocialMention()) &&
                !isNull(socialMention.getTwitterSocialMention().getTweeterAccount());
    }
}
