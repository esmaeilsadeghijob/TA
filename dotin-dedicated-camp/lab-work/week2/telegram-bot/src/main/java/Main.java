import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static List<Person> personList = new ArrayList<>();
    public static Map<Long, String> loginUsers = new ConcurrentHashMap<>();
    public static final Map<String, String> sysMenu = new HashMap<>();
    public static final Map<String, String> userMenu = new HashMap<>();
    public static final Map<String, String> managerMenu = new HashMap<>();
    public static final Map<String, String> adminMenu = new HashMap<>();


    public static void main(String[] args) {

        sysMenu.put("/login username,password","to Login enter username,password after command");
        sysMenu.put("/logout","Logout");
        sysMenu.put("/register username,password","to Register enter username,password after command");

        userMenu.put("/changePassword password","to Change Password enter new password after command");
        userMenu.put("/editUser name,family,email","to EditUser enter name,family,email after command");

        managerMenu.put("/newUser username,password","to NewUser enter username,password after command");
        managerMenu.put("/removeUser username","to RemoveUser enter username after command");
        managerMenu.put("/findUser","FindUser");

        adminMenu.put("/newManager username,password"," to NewManager enter username,password after command");
        adminMenu.put("/removeManager username","to RemoveManager enter username after command");
        adminMenu.put("/findManager","FindManager");

        ApiContextInitializer.init();
        TelegramBotsApi botsApi=new TelegramBotsApi();
        try {
            botsApi.registerBot( new MapsaFatemehBot());
        } catch (TelegramApiRequestException e) {
            System.out.println("Exception...");
            e.printStackTrace();
        }
    }
}
