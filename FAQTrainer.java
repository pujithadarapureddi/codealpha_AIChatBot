import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FAQTrainer {

    public static Map<String, String> loadFAQs() {

        Map<String, String> faqMap = new HashMap<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("faq.txt"));

            String line;

            while((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if(parts.length == 2) {

                    faqMap.put(parts[0].toLowerCase(), parts[1]);
                }
            }

            reader.close();

        } catch(Exception e) {

            System.out.println("FAQ file not found.");
        }

        return faqMap;
    }
}