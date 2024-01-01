package net.herhoffer.mensabot;

import dev.langchain4j.data.segment.TextSegment;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;

@QuarkusTest
class MensaRetrieverTests
{
	@Inject
	MensaRetriever mensaRetriever;
	
	@Test
	void shouldRetrieveFromRedis()
	{
		// when
		List<TextSegment> matches = mensaRetriever.findRelevant("meal");

		// then
		assertThat(matches, not(empty()));
	}	
}
