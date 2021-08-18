import java.util.Scanner;
public class Main{
	public static void main(String[] a){
		System.out.println("please enter your weight and height");
		Scanner s=new Scanner(System.in);
		Float w=s.nextFloat();
		Float h=s.nextFloat();
		Float bmi=w/(h*h);
		if(bmi>25)System.out.println("fat");
		if(bmi<18)System.out.println("thin");
		if(bmi<25 && bmi>18)System.out.println("normal");
	}
}