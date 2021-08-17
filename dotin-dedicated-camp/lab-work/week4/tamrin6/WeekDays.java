package ta_workspace.tamrin6;


enum Days{
    SHANBE,YEKSHANBE,DOSHANBE,SESHANBE,CHAHARSHANBE,
    PANJSHANBE,JOOME
}
public class WeekDays {



    public static void main(String[] args) {
        Days selected = Days.YEKSHANBE;
        switch (selected){
            case SHANBE:
                System.out.println(Days.SHANBE);
                break;
            case YEKSHANBE:
                System.out.println(Days.YEKSHANBE);
                break;
            case DOSHANBE:
                System.out.println(Days.DOSHANBE);
                break;
            case SESHANBE:
                System.out.println(Days.SESHANBE);
                break;
            case CHAHARSHANBE:
                System.out.println(Days.CHAHARSHANBE);
                break;
            case PANJSHANBE:
                System.out.println(Days.PANJSHANBE);
                break;
            case JOOME:
                System.out.println(Days.JOOME);
                break;

            default:
                System.out.println("Error ! bad param");
        }
    }

}
