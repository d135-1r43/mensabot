package net.herhoffer.mensabot;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Supplier;

@ApplicationScoped
public class MensaRetriever implements Supplier<RetrievalAugmentor>
{

	private final RetrievalAugmentor augmentor;

	MensaRetriever(ChromaEmbeddingStore store, EmbeddingModel model)
	{
		EmbeddingStoreContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
			.embeddingModel(model)
			.embeddingStore(store)
			.maxResults(3)
			.build();
		augmentor = DefaultRetrievalAugmentor
			.builder()
			.contentRetriever(contentRetriever)
			.build();
	}

	@Override
	public RetrievalAugmentor get()
	{
		return augmentor;
	}
}