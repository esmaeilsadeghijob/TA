package mrfnBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface UserActions {
    SendMessage showInfo(SendMessage message);
}
