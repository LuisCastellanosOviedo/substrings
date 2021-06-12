package co.com.refactor.controller.definition;

import co.com.refactor.model.SocialMention;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

public interface SocialMentionControllerDef {

    @Post("/AnalyzeSocialMention")
    @Produces(MediaType.TEXT_PLAIN)
    String analyze(@Body SocialMention socialMention);
}
