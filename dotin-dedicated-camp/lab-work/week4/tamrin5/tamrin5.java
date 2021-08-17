package ta_workspace.tamrin5;

public class tamrin5 {
    static boolean checkLenght(String text){
        if (text == null)
            throw new NullPointerException("Error Null parametr !");
        else if (text.length()>4)
            return true;
        else return false;
    }

    public static void main(String[] args) {

        try{
            System.out.println(1/0);
            int[] userId = new int[2];
            userId[4]=4;
            checkLenght(null);

        }catch (ArithmeticException A){
            System.out.println(A);
        }catch (ArrayIndexOutOfBoundsException B){
            System.out.println(B);
        }catch (NullPointerException N){
            System.out.println(N);
        }
    }
}
