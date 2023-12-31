package net.herhoffer.mensabot;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
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
