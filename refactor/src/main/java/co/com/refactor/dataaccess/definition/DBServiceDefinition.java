package co.com.refactor.dataaccess.definition;

public interface DBServiceDefinition {
    void insertFBPost(String analyzedFbTable, Double facebookScore, String message, String facebookAccount);

    void insertTweet(String analyzedTweetsTable, Double tweeterScore, String message, String tweeterUrl, String tweeterAccount);
}
