package co.com.refactor;

import co.com.refactor.model.SocialMention;
import co.com.refactor.analyzer.AnalyzerFactory;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.controller.definition.SocialMentionControllerDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SocialMentionController implements SocialMentionControllerDef {

    private static final String NO_DATA_PRESENT_FOR_FACEBOOK_TWITTER = "Error, Tweeter or Facebook account must be present";

    private final AnalyzerFactory analyzerFactory;

    @Autowired
    public SocialMentionController(AnalyzerFactory analyzerFactory) {
        this.analyzerFactory = analyzerFactory;
    }

    public String analyze(SocialMention socialMention) {
        Optional<Analyzer> analyzer = analyzerFactory.getAnalyzer(socialMention);

        if (analyzer.isPresent()) {
            return analyzer.get().analyze(socialMention).getMessage();
        }
        return NO_DATA_PRESENT_FOR_FACEBOOK_TWITTER;
    }


}
