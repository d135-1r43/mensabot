package net.herhoffer.mensabot;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MealMenuTool
{
	@Tool("gets the current week's menu as an XML string")
	public String getThisWeeksMenuAsXML()
	{
		return null;
	}
}
