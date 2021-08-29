import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int length = scanner.nextInt();
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++)
            intArray[i] = (int) (Math.random() * 100);
        System.out.println("Enter index you want that value: ");
        int index = scanner.nextInt();

        try {
            int value = intArray[index];
            System.out.println("Random value: " + value);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index:(");
        } finally {
            System.out.println("Made me happy to use me:)");
            scanner.close();
        }
    }
}

