package co.com.refactor.analyzer.message;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacebookMessageDelegate {

    private static final String FACEBOOK_MESSAGE_SUFFIX = "facebookMessage: ";
    private static final String COMMENTS_MESSAGE = " || comments: ";

    public String buildMessage(String facebookMessage, List<String> facebookComments) {
        facebookMessage = FACEBOOK_MESSAGE_SUFFIX + facebookMessage;
        String comments = facebookComments
                .stream().reduce("", (h, c) -> h + " " + c);
        return facebookMessage + COMMENTS_MESSAGE + comments;
    }
}
