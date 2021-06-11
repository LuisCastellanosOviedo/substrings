package co.com.refactor;

import co.com.refactor.analyzer.AnalyzerFactory;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.dataaccess.DBService;
import io.micronaut.http.MediaType;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SocialMentionController {

    public static final String ANALYZED_TWEETS_TABLE = "analyzed_tweets";
    public static final String ANALYZED_FB_TABLE = "analyzed_fb_posts";
    private DBService dbService = new DBService("localhost", 5432); // database host and port

    @Autowired
    private AnalyzerFactory analyzerFactory;


    @Post("/AnalyzeSocialMention")
    @Produces(MediaType.TEXT_PLAIN)
    public String analyze(@Body SocialMention socialMention) {
        double facebookCommentsScore = 0;
        boolean isFacebook = false;
        boolean isTweeter = false;
        Double facebookScore = 0d; // General facebook score based on comments and message
        Double tweeterScore = 0d; // General facebook score based on comments and message


        Optional<Analyzer> analyzer = analyzerFactory.getAnalyzer(socialMention);

        if (analyzer.isPresent()) {
            return analyzer.get().analyze(socialMention).getMessage();
        }
        return "Error, Tweeter or Facebook account must be present";

    }


}
