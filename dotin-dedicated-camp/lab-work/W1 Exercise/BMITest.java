import java.util.Scanner;

public class BMITest{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		int weight1 = input.nextInt();
		float height1 = input.nextFloat();

		int weight2 = input.nextInt();
		float height2 = input.nextFloat();

		BMI mahdi = new BMI(height1, weight1);	
        	BMI masood = new BMI(height2, weight2);

		mahdi.printDisplay();
		masood.printDisplay();	

	}

}