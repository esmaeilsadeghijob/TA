import java.util.Scanner;

public class BMI {
    private float weight;
    private float length;
    private float BMIRate;

    public BMI(float weight, float length) {
        this.weight = weight;
        this.length = length;
    }

    public float calculateBMI() {
        BMIRate = weight / (length * length);
        return BMIRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert weight to kg");
        float weight = scanner.nextFloat();
        System.out.println("insert length to m");
        float length = scanner.nextFloat();

        BMI bmi = new BMI(weight, length);
        System.out.printf("%.2f", bmi.calculateBMI());
    }
}
