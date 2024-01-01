package net.herhoffer.mensabot;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

@QuarkusTest
class MensaBotTests
{
	@Inject
	MensaBot mensaBot;

	@Test
	void shouldGiveAnAnswer()
	{
		// when
		String answer = mensaBot.chat("8CFD9692-C065-450F-BCB7-62F3E65B71FF", "What can you recommend today?");

		// then
		assertThat(answer, not(emptyOrNullString()));
	}
}
