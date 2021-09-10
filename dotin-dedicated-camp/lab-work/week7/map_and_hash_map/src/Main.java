import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> students = new HashMap<>();
        while (true) {
            System.out.print("enter student id(press -1 to exit): ");
            int studentId = scanner.nextInt();
            if (studentId == -1)
                break;
            if (students.containsKey(studentId)) {
                System.out.println("student id is duplicate!");
                continue;
            }
            System.out.print("enter student name: ");
            String studentName = scanner.next();
            students.put(studentId, studentName);
        }
        System.out.print("enter student id to find name: ");
        int key = scanner.nextInt();
        String name = "";
        for (Map.Entry<Integer, String> entry:students.entrySet()) {
            if (entry.getKey() == key) {
                name = entry.getValue();
                break;
            }
        }
        if (name.equals(""))
            System.out.println("not found!");
        else
            System.out.println(name);

    }
}
