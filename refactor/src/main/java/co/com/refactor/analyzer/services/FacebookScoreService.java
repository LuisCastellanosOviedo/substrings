package co.com.refactor.analyzer.services;

import co.com.refactor.analyzer.delegate.facebook.FacebookPostAnalyzerDelegate;
import co.com.refactor.analyzer.delegate.facebook.FacebookScoreDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookScoreService {

    private static final int SCORE_LIMIT = -100;

    private final FacebookPostAnalyzerDelegate facebookPostAnalyzerDelegate;

    private final FacebookScoreDelegate facebookScoreDelegate;

    @Autowired
    public FacebookScoreService(FacebookPostAnalyzerDelegate facebookPostAnalyzerDelegate,
                                FacebookScoreDelegate facebookScoreDelegate) {
        this.facebookPostAnalyzerDelegate = facebookPostAnalyzerDelegate;
        this.facebookScoreDelegate = facebookScoreDelegate;
    }

    public Double defineScore(String message, String facebookAccount) {
        Double facebookScore = facebookScoreDelegate.calculateScore(message);
        if (facebookScore > SCORE_LIMIT) {
            facebookScore = facebookPostAnalyzerDelegate.analyzePost(message, facebookAccount);
        }
        return facebookScore;
    }
}
