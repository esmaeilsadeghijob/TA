import java.util.Scanner;

public class PersonBmi {
    private String name;
    private float height, weight;

    public PersonBmi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bmi Calculator");
        System.out.print("Please enter your name : ");
        this.name = scanner.nextLine();
        System.out.print("Please enter your height in m : ");
        this.height = scanner.nextFloat();
        System.out.print("Please enter your weight kg : ");
        this.weight = scanner.nextFloat();
        System.out.println("*******************************************");
        showResult();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float calculateBmi() {
        return weight / (height * height);
    }

    public void showResult() {
        if (calculateBmi() < 18.5)
            System.out.println("Dear " + name + " your bmi is : " + calculateBmi() + " and you are underweight");
        else if (calculateBmi() > 18.5 && calculateBmi() <= 25)
            System.out.println("Dear " + name + " your bmi is : " + calculateBmi() + " and your bmi is normal");
        else if (calculateBmi() > 25)
            System.out.println("Dear " + name + " your bmi is : " + calculateBmi() + " and you are overweight");
    }
}
