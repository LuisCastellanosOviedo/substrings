package co.com.refactor.analyzer.risks;

import co.com.refactor.analyzer.risks.dto.RiskDto;
import co.com.refactor.analyzer.risks.definition.DefaultRiskDefinition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import static co.com.refactor.analyzer.risks.rules.TwitterRiskRules.*;
import static co.com.refactor.analyzer.risks.constants.RiskConstants.*;

@Component
@Qualifier("twitterRisk")
public class TwitterRiskBuilder implements DefaultRiskDefinition {

    private Map<Predicate<Double>, String> twitterRisk;
    private Map<Predicate<Double>, String> facebookrisk;

    @PostConstruct
    private void initTwitterRisk() {
        twitterRisk = new HashMap<>();

        twitterRisk.put(highRisk, HIGH_RISK);
        twitterRisk.put(mediumRisk, MEDIUM_RISK);
        twitterRisk.put(lowRisk, LOW_RISK);
    }

    @PostConstruct
    private void initFacebookRisk() {
        facebookrisk = new HashMap<>();
        facebookrisk.put(lowRisk, LOW_RISK);
    }

    public String defineRiskLevel(RiskDto score) {
        String riskStatus = "";

        Optional<Predicate<Double>> p = twitterRisk.keySet().stream()
                .filter(x -> x.test(score.getTweeterScore())).findFirst();

        if (p.isPresent()) {
            riskStatus = twitterRisk.get(p.get());
        } else {
            p = facebookrisk.keySet().stream()
                    .filter(x -> x.test(score.getFacebookScore())).findFirst();
            riskStatus = p.isPresent() ? facebookrisk.get(p.get()) : riskStatus;
        }

        return riskStatus;

    }


}
