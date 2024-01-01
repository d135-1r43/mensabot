package net.herhoffer.mensabot.rag;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import io.quarkiverse.langchain4j.redis.RedisEmbeddingStore;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;

@QuarkusTest
class MensaIngestorTests
{
	@Inject
	MensaIngestor mensaIngestor;

	@Inject
	EmbeddingModel embeddingModel;

	@Inject
	RedisEmbeddingStore store;

	@Test
	void shouldIngestAsDocument()
	{
		// when
		mensaIngestor.ingest(null);

		// then
		Embedding embeddedText = embeddingModel.embed("meal").content();
		List<EmbeddingMatch<TextSegment>> matches = store.findRelevant(embeddedText, 10);
		assertThat(matches, not(empty()));
	}
}
