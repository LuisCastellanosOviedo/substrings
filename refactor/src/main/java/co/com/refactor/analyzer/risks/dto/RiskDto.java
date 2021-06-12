package co.com.refactor.analyzer.risks.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RiskDto {

    private double tweeterScore;
    private double facebookScore;
}
