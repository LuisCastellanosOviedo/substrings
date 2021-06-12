package co.com.refactor.analyzer;

import co.com.refactor.model.FacebookSocialMention;
import co.com.refactor.model.SocialMention;
import co.com.refactor.analyzer.definition.Analyzer;
import co.com.refactor.analyzer.domain.AnalyzerResponse;
import co.com.refactor.analyzer.risks.dto.RiskDto;
import co.com.refactor.analyzer.message.FacebookMessageDelegate;
import co.com.refactor.analyzer.risks.definition.DefaultRiskDefinition;
import co.com.refactor.analyzer.services.FacebookScoreService;
import co.com.refactor.dataaccess.FacebookDBService;
import co.com.refactor.dataaccess.dbmodel.FacebookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static java.util.Objects.isNull;

@Component
public class FacebookAnalyzer implements Analyzer {

    @Autowired
    private FacebookDBService facebookDbService;

    @Autowired
    @Qualifier("facebookRisk")
    private DefaultRiskDefinition riskBuilder;

    @Autowired
    private FacebookScoreService facebookScoreService;

    @Autowired
    private FacebookMessageDelegate facebookMessageDelegate;

    private Predicate<Double> scoreNeededToPersist = x -> x > -100;


    @Override
    public AnalyzerResponse analyze(final SocialMention socialMention) {
        FacebookSocialMention facebookSocialMention = socialMention.getFacebookSocialMention();
        AnalyzerResponse analyzerResponse = new AnalyzerResponse();
        Double facebookScore = 0d;

        String message = facebookMessageDelegate
                .buildMessage(facebookSocialMention.getMessage(), facebookSocialMention.getFacebookComments());

        analyzerResponse.setMessage(message);

        facebookScore = facebookScoreService
                .defineScore(analyzerResponse.getMessage(), facebookSocialMention.getFacebookAccount());

        FacebookEntity facebookEntity = new FacebookEntity(facebookScore, analyzerResponse.getMessage()
                , facebookSocialMention.getFacebookAccount());
        persistFacebookData(facebookEntity, scoreNeededToPersist);


        analyzerResponse.setMessage(riskBuilder.defineRiskLevel(RiskDto.builder().facebookScore(facebookScore).build()));
        return analyzerResponse;
    }

    private void persistFacebookData(FacebookEntity facebookEntity, Predicate<Double> hasScoreToPersist) {
        if (hasScoreToPersist.test(facebookEntity.getFacebookScore())) {
            facebookDbService
                    .insertFBPost(facebookEntity);
        }
    }

    @Override
    public Boolean getType(SocialMention socialMention) {
        return !isNull(socialMention.getFacebookSocialMention()) &&
                !isNull(socialMention.getFacebookSocialMention().getFacebookAccount());
    }
}
