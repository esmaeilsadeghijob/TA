import mrfnBot.MainMenu;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MrfnBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "mapsamohammadrezabot";
    }

    @Override
    public String getBotToken() {
        return "1903965516:AAEKVZ5vcyElp1Js-n4zHHydcZU452leMIQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage message = MainMenu.getMessage(update);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
