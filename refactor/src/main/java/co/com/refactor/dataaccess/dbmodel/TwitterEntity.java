package co.com.refactor.dataaccess.dbmodel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwitterEntity {

    private Double tweeterScore;
    private String message;
    private String tweeterUrl;
    private String tweeterAccount;
}
