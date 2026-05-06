package labs.example.chatbot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class chatBot {

    // IMPORTANT: Replace this with your actual API key
    private static final String API_KEY = "AIzaSyCH1MAm_ir1-xOjS1knMnZ3jHjP2Bo1uOA";
    private static final String MODEL = "gemini-3-flash-preview";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Gemini AI Chatbot (Java) ---");
        System.out.println("Type your message (or 'exit' to quit):");

        while (true) {
            System.out.print("\nYou: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String response = callGemini(userInput);
                System.out.println("AI: " + response);
            } catch (Exception e) {
                System.err.println("Error calling AI: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static String callGemini(String prompt) throws Exception {
        // 1. Construct the URI and URL
        String urlString = "https://generativelanguage.googleapis.com/v1beta/models/" 
                         + MODEL + ":generateContent?key=" + API_KEY;
        URI uri = new URI(urlString);
        URL url = uri.toURL();

        // 2. Open Connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // 3. Create JSON Payload
        // Note: For production, use a library like Jackson or Gson for JSON
        String jsonInputString = "{\"contents\": [{\"parts\": [{\"text\": \"" + prompt + "\"}]}]}";

        // 4. Send Request
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 5. Read Response
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                
                // Parse the response to extract the chatbot's response text
                String[] responseLines = response.toString().split("\"text\":");
                if (responseLines.length > 1) {
                    String[] finalResponseForm = responseLines[1].split(",\"");
                    return finalResponseForm[0].trim();
                } else {
                    throw new RuntimeException("Unexpected response format from AI.");
                }
            }
        } else {
            throw new RuntimeException("HTTP Status: " + responseCode);
        }
    }
}