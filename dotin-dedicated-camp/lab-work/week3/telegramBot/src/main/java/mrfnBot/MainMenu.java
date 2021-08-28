package mrfnBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {
    public static ArrayList<User> UserList = new ArrayList<>();



    public static SendMessage getMessage(Update update){
        System.out.println(update.getMessage().getChat().getFirstName() +"  => "+update.getMessage().getText());
        long id = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
    if ( UserList.indexOf(new User(id)) == -1){
        String name = update.getMessage().getChat().getFirstName();
        String family = update.getMessage().getChat().getLastName();
        String username = update.getMessage().getChat().getUserName();
        long userid = update.getMessage().getChatId();
        UserList.add(new User(name,family,username,userid));
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(update.getMessage().getChat().getFirstName()+" شما با موفقیت در ربات ثبت نام شدید !\n" +
                " جهت مشاهده اطلاعات خود از دستور زیر استفاده کنید \n" +
                "/info ");
        return message;
    }

        int fid = UserList.indexOf(new User(id));

    if (update.getMessage().getText().equals("/info")){
        return  UserList.get(fid).showInfo(message);
    }



        message.setChatId(String.valueOf(UserList.get(fid).getId()));
        message.setText("شما قبلا در ربات ثبت نام نموده اید !! لطفا جهت مشاهده اطلاعات خود از دستور زیر استفاده کنید \n" +
                "/info");
    return message;
    }
}
