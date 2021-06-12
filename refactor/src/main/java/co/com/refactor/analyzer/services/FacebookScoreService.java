package co.com.refactor.analyzer.services;

import co.com.refactor.analyzer.delegate.facebook.FacebookPostAnalyzerDelegate;
import co.com.refactor.analyzer.delegate.facebook.FacebookScoreDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookScoreService {

    @Autowired
    private FacebookPostAnalyzerDelegate facebookPostAnalyzerDelegate;

    @Autowired
    private FacebookScoreDelegate facebookScoreDelegate;

    public Double defineScore(String message, String facebookAccount) {
        Double facebookScore = facebookScoreDelegate.calculateScore(message);
        if (facebookScore > -100) {
            facebookScore = facebookPostAnalyzerDelegate.analyzePost(message, facebookAccount);
        }
        return facebookScore;
    }
}
