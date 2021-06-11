package co.com.refactor.analyzer.dto.risk;

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
