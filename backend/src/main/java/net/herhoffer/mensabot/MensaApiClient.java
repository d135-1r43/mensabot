package net.herhoffer.mensabot;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/mensa/")
@RegisterRestClient(configKey="neuland")
public interface MensaApiClient
{
	@GET
	String getMensaJson();
}
