import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MapsaBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
    /*
      String input = update.getMessage().getText();
        long userId = update.getMessage().getChatId();
        String message = "welcome to NILOOOFAR bot";
       SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userId);
       sendMessage.setText(message);
       try {
          execute(sendMessage);
      } catch (Exception e) {
          e.printStackTrace();
      }
   */
        if(update.hasMessage()){
            Message message = update.getMessage();

            if(message.hasText()){

                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString());
                sendMessageRequest.setText("سلااااام " + message.getText());
                try {
                    sendMessage(sendMessageRequest);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }



    }


    @Override
    public String getBotUsername() {
        return BotConfig.USERNAMEMYPROJECT;
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKENMYPROJECT;
    }
}