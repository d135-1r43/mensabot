import {LitElement, html, css} from 'lit';
import '@vaadin/icon';
import '@vaadin/button';
import '@vaadin/text-field';
import '@vaadin/text-area';
import '@vaadin/form-layout';
import '@vaadin/progress-bar';
import '@vaadin/checkbox';
import '@vaadin/grid';
import '@vaadin/grid/vaadin-grid-sort-column.js';

export class DemoTitle extends LitElement {

    static styles = css`
        h1 {
            font-family: "Red Hat Mono", monospace;
            font-size: 60px;
            font-style: normal;
            font-variant: normal;
            font-weight: 700;
            line-height: 26.4px;
            color: var(--main-highlight-text-color);
        }

        .title {
            text-align: center;
            padding: 1em;
            background: var(--main-bg-color);
        }

        .explanation {
            margin-left: auto;
            margin-right: auto;
            width: 50%;
            text-align: justify;
            font-size: 20px;
        }

        .explanation img {
            max-width: 60%;
            display: block;
            float: left;
            margin-right: 2em;
            margin-top: 1em;
        }
    `

    render() {
        return html`
            <div class="title">
                <h1>Mensa Bot (Dev UI)</h1>
            </div>
            <div class="explanation">
                This chatbot is a progressive tool built upon Language Model (LLM)
                technology. It is created specifically to answer queries revolving around the lunch menu at the
                university's canteen. Designed with a focus on delivering immediate, automated, and precise replies, it
                provides information on a range of topics such as the food offered, the ingredients used, potential
                allergens present, and even the nutritional content.
                The crux of the chatbot lies in its ability to comprehend and construct textual responses, powered by
                Quarkus and LangChain4j with OpenAI. With these technologies, it can engage users in a conversational
                format, promptly assisting them in deciphering the meal choices at the university.
                The chatbot doesn't limit itself solely to the lunch menu, but also responds to general questions about
                the university canteen such as its operating hours and accepted payment modes.
                Employing machine learning mechanisms, the bot is capable of self-learning and iterative improvement. It
                acclimatizes to new data patterns (like updated dish offerings), adjusts to changes in user habits, and
                continually refines the pertinence and accuracy of its generated responses.
            </div>
            <div class="explanation">
                <ol>
                    <li>The user send a question to the application.</li>
                    <li>The application looks for relevant data in the Redis store that is filled with data from the
                        Neuland API.
                    </li>
                    <li>The relevant data is retrieved and added to the user's question.</li>
                    <li>The extended question is sent to the LLM model.</li>
                    <li>The response is received and sent back to the user.</li>
                </ol>
            </div>
        `
    }
}

customElements.define('demo-title', DemoTitle);