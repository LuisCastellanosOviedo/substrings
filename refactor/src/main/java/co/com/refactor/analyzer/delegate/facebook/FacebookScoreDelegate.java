package co.com.refactor.analyzer.delegate.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookScoreDelegate {

    private static final double COMMENT_SCORE_NEEDED_REMOVE_SCORE = 50d;
    private static final double SCORE = -100d;
    private static final String COMMENTS_TAG = "comments:";

    private final  FacebookCommentStoreDelegate FacebookCommentStoreDelegate;

    @Autowired
    public FacebookScoreDelegate(FacebookCommentStoreDelegate facebookCommentStoreDelegate) {
        FacebookCommentStoreDelegate = facebookCommentStoreDelegate;
    }

    public Double calculateScore(String comments) {

        double facebookCommentsScore = 0;
        double facebookScore = 0d;

        if (hasComments(comments)) {
            facebookCommentsScore = FacebookCommentStoreDelegate
                    .calculateFacebookCommentsScore(comments.substring(comments.indexOf(COMMENTS_TAG)));
            if (facebookCommentsScore < COMMENT_SCORE_NEEDED_REMOVE_SCORE) {
                facebookScore = Double.sum(facebookScore, SCORE);
            }
        }
        return facebookScore;
    }

    private boolean hasComments(String comments) {
        return comments.contains(COMMENTS_TAG);
    }
}
