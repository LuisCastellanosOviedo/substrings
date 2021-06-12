package co.com.refactor.analyzer.risks.definition;

import co.com.refactor.analyzer.risks.dto.RiskDto;

public interface DefaultRiskDefinition {

    String defineRiskLevel(RiskDto score);
}
