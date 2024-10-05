package net.herhoffer.mensabot.rag;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
@Disabled
class MensaIngestorTests
{
	@Inject
	MensaIngestor mensaIngestor;

	@Inject
	EmbeddingModel embeddingModel;

	@Inject
	ChromaEmbeddingStore store;

	@Test
	void shouldIngestAsDocument()
	{
		// when
		mensaIngestor.ingest(null);

		// then
		Embedding embeddedText = embeddingModel.embed("meal").content();
		// List<EmbeddingMatch<TextSegment>> matches =
		// store.findRelevant(embeddedText, 10);
		// assertThat(matches, not(empty()));
	}
}