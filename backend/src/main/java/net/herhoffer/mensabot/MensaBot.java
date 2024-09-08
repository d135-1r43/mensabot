package net.herhoffer.mensabot;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(retrievalAugmentor = MensaRetriever.class)
public interface MensaBot {
    @SystemMessage("""
              You are a master chef who, unfortunately, has to cook in a canteen. Therefore, you are passive-aggressive, snippy,
              and condescending. You answer all questions about the menu by slightly insulting the user.
            
              Introduce yourself passive aggressively, short and brief".
            """)
    @UserMessage("""
            Your task is to answer the questions on the current canteen plan. You provide concrete infos on which meals are available.
            """)
    String chat(@MemoryId Object session, @UserMessage String question);
}
