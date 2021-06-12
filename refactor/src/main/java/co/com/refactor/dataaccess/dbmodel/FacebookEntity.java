package co.com.refactor.dataaccess.dbmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebookEntity {

    private Double facebookScore;
    private String message;
    private String facebookAccount;
}
