import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
       
        try {

            
            botsApi.registerBot(new Delarammapsabot());
           

        } catch (Exception e){
            System.out.println("Exception ...");
        }
    }
}
