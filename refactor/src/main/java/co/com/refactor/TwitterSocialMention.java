package co.com.refactor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwitterSocialMention extends SocialMentionCommon {
    private String tweeterUrl;
    private String tweeterAccount;
}
