
import java.util.Scanner;
public class BMI{
public static void main(String arg[]){
	
	Scanner input=new Scanner(System.in);
	
	System.out.println("vazn khod ra be kg vared konid");
    float weight=input.nextFloat();
	
	System.out.println("ghad khod rabe santi metr vared konid");
	float height=input.nextFloat();


	float result=BMI(weight,height);
	System.out.println("bmi shoma  : " + result + "       " + getresult(result) );
}

public static float BMI(float a,float b){

	float bmi= a/(b*b);
	return bmi;	
}
public static String getresult(float c){

	if (c < 0.00185 ){
		return ("laghar hasti");
		}
		else if(c > 0.00185 && c <= 0.0025){
		return ("normal hasti");
		}
		else if(c > 0.0025 && c <= 0.0030){
			return ("kami ezafe vazn dari");
		}
		else if(c > 0.0030 && c <= 0.0035){
			return ("daraye chaghi motevaset");
		}
		else if(c > 0.0035 && c <= 0.0040){
			return ("daray chaghi ziyad");
		}
		else if(c > 0.0040){
			return ("daray chaghi margbar va bish az had");
		}
		else
			return ("eshtebah ast");
}
}


