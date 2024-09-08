package net.herhoffer.mensabot;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
class MensaRetrieverTests {
    @Inject
    MensaRetriever mensaRetriever;

    @Test
    @Disabled
    void shouldRetrieveFromRedis() {
        // when
        // List<TextSegment> matches = mensaRetriever.get().findRelevant("meal");

        // then
        // assertThat(matches, not(empty()));
    }
}
