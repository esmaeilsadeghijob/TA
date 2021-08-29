import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Delarammapsabot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String input = update.getMessage().getText();
        long userId = update.getMessage().getChatId();

        String message = "welcome to delaram bot";


        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public String getBotUsername() {
        return "MapsaEsmailbot";
    }

    @Override
    public String getBotToken() {
        return  "1932434704:AAGIJwHLr4nHZW-_zSQhz4YxlsajAP4HCdA";
    }
}
