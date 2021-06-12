package co.com.refactor.analyzer.delegate.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookScoreDelegate {

    @Autowired
    private FacebookCommentStoreDelegate FacebookCommentStoreDelegate;

    public Double calculateScore(String comments) {

        double facebookCommentsScore = 0;
        double facebookScore = 0d;

        if (comments.contains("comments:")) {
            facebookCommentsScore = FacebookCommentStoreDelegate.calculateFacebookCommentsScore(comments.substring(comments.indexOf("comments:")));
            if (facebookCommentsScore < 50d) {
                facebookScore = Double.sum(facebookScore, -100d);
            }
        }
        return facebookScore;
    }
}
