# Mensa Bot

This chatbot is a progressive tool built upon OpenAI API. It is created specifically to answer queries revolving around
the lunch menu at the university's canteen. Designed with a focus on delivering immediate, automated, and precise
replies, it provides information on a range of topics such as the food offered, the ingredients used, potential
allergens present, and even the nutritional content.

The crux of the chatbot lies in its ability to comprehend and construct textual responses, powered by
Quarkus and LangChain4j with OpenAI. With these technologies, it can engage users in a conversational
format, promptly assisting them in deciphering the meal choices at the university.

The chatbot doesn't limit itself solely to the lunch menu, but also responds to general questions about
the university canteen such as its operating hours and accepted payment modes.

Employing machine learning mechanisms, the bot is capable of self-learning and iterative improvement. It
acclimatizes to new data patterns (like updated dish offerings), adjusts to changes in user habits, and
continually refines the pertinence and accuracy of its generated responses.

The process works as follows:

1. The user sends a question to the application.
2. The application looks for relevant data in the Redis store that is filled with data from the
   [Neuland API](https://neuland.app/api/mensa/).
3. The relevant data is retrieved and added to the user's question.
4. The extended question is sent to the LLM model.
5. The response is received and sent back to the user.

## backend

The backend is a Java service written in Quarkus with LangChain4j.

### Configure

Bring your own OpenAI API key by adding `QUARKUS_LANGCHAIN4J_OPENAI_API_KEY=sk-yourkey` in the new file `backend/.env`.
It will be sources by Quarkus automatically on startup.

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

### Creating a native executable

You can create a native executable using:
Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
You can then execute your native executable with: `./target/mensabot-$version-runner`

If you want to learn more about building native executables, please
consult [Quarkus Maven tooling guide](https://quarkus.io/guides/maven-tooling).