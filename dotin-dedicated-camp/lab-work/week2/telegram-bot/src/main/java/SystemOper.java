import java.util.Map;

public class SystemOper {

    public String showMenu(String menuId) {
        String msg = "Welcome to Fatemeh Bot \n\n";
        Map<String, String> menu;

        switch (menuId) {
            case "system":
                menu = Main.sysMenu;
                break;
            case "user":
                menu = Main.userMenu;
                break;
            case "manager":
                menu = Main.managerMenu;
                break;
            case "admin":
                menu = Main.adminMenu;
                break;
            default:
                menu = Main.sysMenu;
        }

        for (String command : menu.keySet()) {
            msg += command + " - " + menu.get(command) + "\n";
        }

        return msg;
    }

}
