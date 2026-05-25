import java.util.Map;
public class ChatBotLogic {

    Map<String, String> faqMap;

    public ChatBotLogic() {

        faqMap = FAQTrainer.loadFAQs();
    }

    public String getResponse(String input) {

        input = processInput(input);

        // FAQ Matching
        for(String question : faqMap.keySet()) {

            if(input.contains(question)) {
                return faqMap.get(question);
            }
        }

        // Rule-based Responses
        if(input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        if(input.contains("name")) {
            return "I am a Java AI ChatBot.";
        }

        if(input.contains("java")) {
            return "Java is a powerful object-oriented programming language.";
        }

        if(input.contains("bye")) {
            return "Goodbye! Have a nice day.";
        }

        return "Sorry, I don't understand that.";
    }

    // NLP Technique (Basic preprocessing)
    private String processInput(String input) {

        input = input.toLowerCase();

        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        return input;
    }
}