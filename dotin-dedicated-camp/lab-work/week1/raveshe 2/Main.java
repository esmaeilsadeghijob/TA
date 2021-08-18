import java.util.Scanner;
public class Main{
	public static void main(String[] a){
		System.out.println("please enter your weight and height");
		Scanner s=new Scanner(System.in);
		Float w=s.nextFloat();
		Float h=s.nextFloat();
		Bmi bmi=new Bmi();
		Float result=bmi.calc(h,w);
		if(result>25)System.out.println("fat");
		if(result<18)System.out.println("thin");
		if(result<25 && result>18)System.out.println("normal");
	}
}