import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MaryamMapsaBot());
        } catch (Exception e){
            System.out.println("Exception ...");
        }
    }
}
