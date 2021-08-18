import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        int count=0;
        String[] d=new String[100];
        String[] p=new String[100];
        Scanner s=new Scanner(System.in);
        try {

            System.out.println("please enter username");

            d[count]=s.next();
            System.out.println("please enter password");

            p[count]=s.next();
            botsApi.registerBot(new Delarammapsabot());
            count++;

        } catch (Exception e){
            System.out.println("Exception ...");
        }
    }
}
