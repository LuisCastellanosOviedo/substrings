package co.com.refactor.analyzer.risks;

import co.com.refactor.analyzer.dto.risk.RiskDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static co.com.refactor.analyzer.risks.FacebookRiskRules.*;
import static co.com.refactor.analyzer.risks.RiskConstants.*;

@Component
@Qualifier("facebookRisk")
public class FacebookRiskBuilder implements DefaultRiskDefinition {

    private Map<Predicate<Double>, String> risk;

    @PostConstruct
    private void initRisk() {
        risk = new HashMap<>();

        risk.put(highRisk, HIGH_RISK);
        risk.put(mediumRisk, MEDIUM_RISK);
        risk.put(lowRisk, LOW_RISK);
    }

    public String defineRiskLevel(RiskDto score) {
        return risk.get(risk.keySet().stream().filter(x -> x.test(score.getFacebookScore())).findFirst().get());
    }


}
