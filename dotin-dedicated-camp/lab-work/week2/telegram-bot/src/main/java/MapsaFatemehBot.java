import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MapsaFatemehBot extends TelegramLongPollingBot {

    private SystemOper systemOper = new SystemOper();
    SendMessage sendMessage = new SendMessage();


    @Override
    public void onUpdateReceived(Update update) {

        String input = update.getMessage().getText();
        long pid = update.getMessage().getChatId();
        int msgId = update.getMessage().getMessageId();

        String command = input.split(" ")[0];

        switch (command) {
            case "/start":
                sendMsg(systemOper.showMenu("system"), pid, msgId);
                break;
            case "/login":
                // TODO: 8/10/2021
                break;
            case "/register":
                // TODO: 8/10/2021
                break;
            case "/changePassword":
                // TODO: 8/10/2021
                break;
            case "/logout":
                // TODO: 8/10/2021
                break;
        }
    }
    @Override
    public String getBotUsername() {
        return "MapsaEsmailbot";
    }

    @Override
    public String getBotToken() {
        return "1932434704:AAGIJwHLr4nHZW-_zSQhz4YxlsajAP4HCdA";
    }

    public void sendMsg(String msg, long pid, int msgId){
        sendMessage.setChatId(pid);
        sendMessage.setText(msg);
        sendMessage.setReplyToMessageId(msgId);


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
