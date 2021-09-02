
public class Enum {
    public enum food{
     kabab,
     pitza,
     hamberger
    }
    public static void main(String[] args) {
        food dir = food.hamberger;
        if (dir == food.kabab) {
            System.out.println("kabab entekhab shode ast");
        } else if (dir == food.pitza) {
            System.out.println("ptiza entekhab shode ast");
        } else if (dir == food.hamberger) {
            System.out.println("hamberger entekhab shode ast");
        } else {
            System.out.println("direction");
        }
    }
}
