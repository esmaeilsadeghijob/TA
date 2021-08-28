package mrfnBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class User extends Person implements UserActions{
    public User(String name, String family, String username, long id) {
        super(name, family, username, id);
    }

    public User(long id) {
        super(id);
    }


    @Override
    public SendMessage showInfo(SendMessage message) {
        message.setChatId(String.valueOf(this.getId()));
        message.setText("نام شما : "+this.getName()+" \n" +
                "فامیلی شما : "+getFamily()+" \n" +
                " ایدی شما : "+this.getId()+" \n" +
                " یوزرنیم شما : "+this.getUsername()+" \n" +
                "امتیاز شما در ربات : 0");

        return message;
    }
}
