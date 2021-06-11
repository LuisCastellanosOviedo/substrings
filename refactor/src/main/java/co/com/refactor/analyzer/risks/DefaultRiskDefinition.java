package co.com.refactor.analyzer.risks;

import co.com.refactor.analyzer.dto.risk.RiskDto;

public interface DefaultRiskDefinition {

    String defineRiskLevel(RiskDto score);
}
