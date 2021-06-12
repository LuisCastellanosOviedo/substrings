package co.com.refactor.dataaccess;

import co.com.refactor.dataaccess.da.access.Connection;
import co.com.refactor.dataaccess.dbmodel.FacebookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookDBService {

    private static final String ANALYZED_TWEETS_TABLE = "analyzed_tweets";

    @Autowired
    private Connection connection;

    public void insertFBPost(FacebookEntity facebookEntity) {
// save to db  connection.save() ....
    }


}
