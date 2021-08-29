import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class UpdateDispatcher {
    private static String state = " ";
    private static String name = "";
    private static String lastName = "";
    private static String userName = "";

    public static SendMessage dispatcher(Update update){

        SendMessage sendMessage = new SendMessage();
        Message inputMessage = update.getMessage();

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            User queryFrom = callbackQuery.getFrom();
            Message messageCallback = callbackQuery.getMessage();
            sendMessage.setChatId(String.valueOf(messageCallback.getChatId()));
            switch (data) {
                case "vorud":
                    //vorudButton(sendMessage, messageCallback);
                    break;
                case "new account":
                    newAccountButton(sendMessage, messageCallback);
                    break;
                default:
            }
        }


        if (update.hasMessage()) {
            String inputMessageText = inputMessage.getText();
            long inputMessageChatId = inputMessage.getChatId();
            sendMessage.setChatId(inputMessageChatId);

            if (inputMessageText.equals("/start"))
                start(sendMessage);
            else
                newAccountButton(sendMessage, inputMessage);
        }



        return sendMessage;
        //executeMessage(message, sendMessage);

    }



    private static void start(SendMessage sendMessage) {
        sendMessage.setText("به ربات تیم مپصا خوش آمدید");

        InlineKeyboardButton firstButton = new InlineKeyboardButton();
        firstButton.setText("ورود");
        firstButton.setCallbackData("vorud");

        InlineKeyboardButton secondButton = new InlineKeyboardButton();
        secondButton.setText("ایجاد حساب");
        secondButton.setCallbackData("new account");

        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(firstButton);
        row.add(secondButton);

        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }

    private static void vorudButton(SendMessage sendMessage, Message messageCallback) {

    }

    private static void newAccountButton(SendMessage sendMessage, Message inputMessage) {
        switch (state) {
            case " " :
                sendMessage.setText("نام خود را وارد کنید: ");
                name = inputMessage.toString();
                state = "newAcoount_name";
                break;
            case "newAcoount_name" :
                sendMessage.setText("نام خانوادگی خود را وارد کنید: ");
                name = inputMessage.toString();
                state = "newAcoount_lastName";
                break;
            case "newAcoount_lastName" :
                sendMessage.setText("نام حساب خود را وارد کنید: ");
                lastName = inputMessage.toString();
                state = "newAcoount_userName";
                break;
            case "newAcoount_userName" :
                userName = inputMessage.toString();
                sendMessage.setText("حساب شما ساخته شد!");
                state = "";
                break;
        }
    }
}

