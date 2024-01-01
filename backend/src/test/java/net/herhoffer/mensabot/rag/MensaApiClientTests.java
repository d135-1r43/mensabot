package net.herhoffer.mensabot.rag;

import io.quarkus.test.junit.QuarkusTest;
import net.herhoffer.mensabot.rag.MensaApiClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class MensaApiClientTests
{
	@RestClient
	MensaApiClient mensaApiClient;

	@Test
	public void shouldFetchTheMenu()
	{
		// when
		String json = mensaApiClient.getMensaJson();

		// then
		assertNotNull(json);
	}
}
