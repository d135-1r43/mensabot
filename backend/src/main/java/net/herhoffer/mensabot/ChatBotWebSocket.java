package net.herhoffer.mensabot;

import io.quarkiverse.langchain4j.ChatMemoryRemover;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.eclipse.microprofile.context.ManagedExecutor;

import java.io.IOException;

@ServerEndpoint("/chatbot")
public class ChatBotWebSocket
{
	@Inject
	CanteenBot mensaBot;

	@Inject
	ManagedExecutor managedExecutor;

	@OnOpen
	public void onOpen(Session session)
	{
		managedExecutor.execute(() -> {
			String response = mensaBot.chat(session, "hello");
			try
			{
				session.getBasicRemote().sendText(response);
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		});
	}

	@OnClose
	void onClose(Session session)
	{
		ChatMemoryRemover.remove(mensaBot, session);
	}

	@OnMessage
	public void onMessage(String message, Session session)
	{
		managedExecutor.execute(() -> {
			String response = mensaBot.chat(session, message);
			try
			{
				session.getBasicRemote().sendText(response);
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		});
	}
}
