package co.com.refactor.analyzer;

import co.com.refactor.FacebookSocialMention;
import co.com.refactor.SocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.dataaccess.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static co.com.refactor.SocialMentionController.ANALYZED_FB_TABLE;
import static java.util.Objects.isNull;

@Component
public class FacebookAnalyzer implements Analyzer {

    @Autowired
    private FacebookCommentStoreDelegate FacebookCommentStoreDelegate;

    @Autowired
    private FacebookPostAnalyzerDelegate facebookPostAnalyzerDelegate;

    @Autowired
    private DBService dbService;

    @Override
    public AnalyzerResponse analyze(SocialMention socialMention) {
        FacebookSocialMention facebookSocialMention = socialMention.getFacebookSocialMention();
        AnalyzerResponse analyzerResponse = new AnalyzerResponse();
        double facebookCommentsScore = 0;
        Double facebookScore = 0d;

        analyzerResponse.setMessage("facebookMessage: " + facebookSocialMention.getMessage());
        String comments = facebookSocialMention.getFacebookComments()
                .stream().reduce("", (h, c) -> h + " " + c);
        analyzerResponse.setMessage(analyzerResponse.getMessage() + " || comments: " + comments);

        if (analyzerResponse.getMessage().contains("comments:")) {
            facebookCommentsScore = FacebookCommentStoreDelegate.calculateFacebookCommentsScore(analyzerResponse.getMessage().substring(analyzerResponse.getMessage().indexOf("comments:")));
            if (facebookCommentsScore < 50d) {
                facebookScore = Double.sum(facebookScore, -100d);
            }
        }

        if (facebookScore > -100) {
            facebookScore = facebookPostAnalyzerDelegate.analyzePost(analyzerResponse.getMessage(), facebookSocialMention.getFacebookAccount());
            dbService.insertFBPost(ANALYZED_FB_TABLE, facebookScore, analyzerResponse.getMessage(), facebookSocialMention.getFacebookAccount());
        }


        if (facebookScore == -100d) {
            analyzerResponse.setMessage("HIGH_RISK");
        } else if (facebookScore > -100d && facebookScore < 50d) {
            analyzerResponse.setMessage("MEDIUM_RISK");
        } else if (facebookScore >= 50d) {
            analyzerResponse.setMessage("LOW_RISK");
        }


        return analyzerResponse;
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return !isNull(socialMention.getFacebookSocialMention()) &&
                !isNull(socialMention.getFacebookSocialMention().getFacebookAccount());
    }
}
