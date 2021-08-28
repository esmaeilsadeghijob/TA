package com.amirbot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;



public class AmirBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String msg = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            /*
            String start = "/start";

            if (msg.equalsIgnoreCase(start)) {
                System.out.println("1");
            } else {
                sendMessage.setChatId(chatId).setText(msg);
            }
            */

            SendMessage sendMessage = new SendMessage();

            if (msg.equalsIgnoreCase( "/start")){
                sendMessage.setChatId(chatId).setText("سلام خوش آمدید");
            }else {
                sendMessage.setChatId(chatId).setText(msg);
            }


            System.out.println(msg);


            try {
                execute(sendMessage);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }




        }

    }

    public String getBotUsername() {
        return "AmirSimpleBot";
    }

    public String getBotToken() {
        return "1944265014:AAETlsEJi-D_gixoYeWFkHDxBKTUudyV3vY";
    }
}
