package co.com.refactor.dataaccess;

import co.com.refactor.dataaccess.definition.DBServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class DBService implements DBServiceDefinition {

    public DBService(String localhost, int i) {

    }

    @Override
    public void insertFBPost(String analyzedFbTable, Double facebookScore, String message, String facebookAccount) {

    }

    @Override
    public void insertTweet(String analyzedTweetsTable, Double tweeterScore, String message, String tweeterUrl, String tweeterAccount) {

    }
}
