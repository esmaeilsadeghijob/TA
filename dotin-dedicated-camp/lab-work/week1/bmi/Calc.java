public class Calc {

    // defining tw variables to take the users weight and heights
    private float ht;
    private float wt;



    public void set_ht(float ht){
        this.ht= ht;
    }

    public double get_ht(){
        return ht;
    }

    public void set_wt(float wt){
        this.wt = wt;
    }

    public double get_wt(){
        return wt;
    }



    public float bmiCalc(float wt, float ht){

        float result = (wt/(ht/100*ht/100));

        System.out.printf("\nResult is: %.2f\nAnd You  ",result);
        if(result < 18.5){
            System.out.println("Are Under Weight");
        }
        else if(result > 18.5 && result < 25){
            System.out.println("Have a Normal Weight");
        }else if(result >= 25 && result < 30){
            System.out.println("Are Over Weight");
        }else{

            System.out.println("Are Obesity !!!");
        }
        return result;
    }
}
