package co.com.refactor.analyzer.message;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacebookMessageDelegate {

    public String buildMessage(String facebookMessage, List<String> facebookComments) {
        facebookMessage = "facebookMessage: " + facebookMessage;
        String comments = facebookComments
                .stream().reduce("", (h, c) -> h + " " + c);
        return facebookMessage + " || comments: " + comments;
    }
}
