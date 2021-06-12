package co.com.refactor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMention {

    private FacebookSocialMention facebookSocialMention;
    private TwitterSocialMention twitterSocialMention;

}
