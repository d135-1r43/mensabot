package net.herhoffer.mensabot.rag;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkiverse.langchain4j.chroma.ChromaEmbeddingStore;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.langchain4j.data.document.splitter.DocumentSplitters.recursive;

@ApplicationScoped
public class MensaIngestor {
    private static final Logger LOG = LoggerFactory.getLogger(MensaIngestor.class);

    @Inject
    ChromaEmbeddingStore store;

    @Inject
    EmbeddingModel embeddingModel;

    public void ingest(@Observes StartupEvent event) {
        LOG.info("ingesting documents");
        Document docs = UrlDocumentLoader.load("https://neuland.app/api/mensa/", new TextDocumentParser());

        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(store)
                .embeddingModel(embeddingModel)
                .documentSplitter(recursive(500, 0))
                .build();

        ingestor.ingest(docs);
        LOG.info("Documents successfully ingested");
    }
}