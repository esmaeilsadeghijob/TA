import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MyArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] number = new int[4];
        String[] name = new String[4];
        // TODO: 8/4/2021 craet myarray
        int count = 0;
        while (count < 4 ) {
            System.out.println("please enter your numbers list.");
            number[count] = s.nextInt();
            System.out.println("please enter your names list.");
            name[count] = s.next();
            count++;
        }
            System.out.println(Arrays.toString(number));
            System.out.println(Arrays.toString(name));
            String myName = s.next();
            for (int i = 0; i < number.length; i++) {
            if (name[i].equalsIgnoreCase(myName)) {
                System.out.println(number[i]);
            }
        }
    }
}
