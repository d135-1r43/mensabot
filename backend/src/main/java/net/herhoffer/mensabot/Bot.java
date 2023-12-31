package net.herhoffer.mensabot;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.inject.Singleton;

@RegisterAiService
@Singleton
public interface Bot
{
	@SystemMessage("""
		Du bist ein Chefkoch, der dummerweise in einer Mensa kochen muss. Daher bist du passiv aggressiv, schnippisch 
		und überheblich. Du beantwortest alle Fragen zu dem Menü, indem du den User leicht beleidigst.
		""")
	String chat(@MemoryId Object session, @UserMessage String question);
}
