import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeleBot extends TelegramLongPollingBot {

//    private List<Account> accounts = new ArrayList<>();
//    private Map<String, String> mapId = new HashMap<>();
//    private String state = "";

    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = UpdateDispatcher.dispatcher(update);
        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String message;
//        String accountName = "", accountLatName = "", accountUserName = "";
//
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String input = update.getMessage().getText();
//            String firstName = update.getMessage().getFrom().getFirstName();
//            String lastName = update.getMessage().getFrom().getLastName();
//            String userName = update.getMessage().getFrom().getUserName();
//            switch (input) {
//                case "/start" :
//                    lastName = (lastName == null) ? "" : " " + lastName;
//                    message = "Hi " + firstName + lastName + " .Welcome:)";
//                    sendMessage(update, message);
//                    message = "Create account: /create\nUse an existing account: /logIn\n";
//                    sendMessage(update, message);
//                    break;
//                case "/create" :
//                    message = "Enter your name: ";
//                    sendMessage(update, message);
//                    state = "create_name";
//                    break;
//                case "/logIn" :
//                    System.out.println("!!!!!!!!!!!!!!");
//                    message = "Enter your name: ";
//                    sendMessage(update, message);
//                    state = "create_name";
//                    break;
//                default:
//                    System.out.println("%%%%%%%%%%%%%%%%%%%");
//                    switch (state) {
//                        case "create_name" :
//                            accountName = input;
//                            message = "Enter your last name: ";
//                            sendMessage(update, message);
//                            state = "create_lastName";
//                            break;
//                        case "create_lastName" :
//                            accountLatName = input;
//                            message = "Enter your username: ";
//                            sendMessage(update, message);
//                            state = "create_userName";
//                            break;
//                        case "create_userName" :
//                            accountUserName = input;
//                            if (mapId.containsKey(accountUserName)){
//                                message = "Username is reserved! enter another: ";
//                                sendMessage(update, message);
//                                break;
//                            }
//                            mapId.put(accountUserName, accountName);
//                            accounts.add(new Account(accountName, accountLatName, accountUserName));
//                            message = "You'r account created!";
//                            sendMessage(update, message);
//                            state = " ";
//                            break;
//                    }
//                    break;
//            }
//        }
    }

    public void sendMessage(Update update, String message) {
        long userId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "FatemehMapsaBot";
    }

    public String getBotToken() {
        return "1932472260:AAFUpg3ncdjIVaHw-ZrWUqKLsfSqQfcD5pA";
    }
}

