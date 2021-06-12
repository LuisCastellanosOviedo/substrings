package co.com.refactor.dataaccess;

import co.com.refactor.dataaccess.da.access.Connection;
import co.com.refactor.dataaccess.dbmodel.TwitterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwitterDBService {

    private static final String ANALYZED_FB_TABLE = "analyzed_fb_posts";

    @Autowired
    private Connection connection;

    public void insertTweet(TwitterEntity twitterEntity) {
// save to db  connection.save() ....
    }
}
