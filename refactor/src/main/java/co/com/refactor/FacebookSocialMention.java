package co.com.refactor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebookSocialMention extends SocialMentionCommon {
    private String facebookAccount;
    private List<String> facebookComments;
}
