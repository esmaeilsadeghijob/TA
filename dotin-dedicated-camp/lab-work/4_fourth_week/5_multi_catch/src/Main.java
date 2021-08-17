public class Main {
    class DivideToZero extends Exception{
        public DivideToZero (String errorMessage){
            super(errorMessage);
        }
    }
    public int divide (int num1, int num2) throws DivideToZero {
        if (num2 == null)
            throw new NullPointerException("Number  is null");
        if (num2 == 0)
            throw new DivideToZero("Number 2 cant be zero");
        else
            return num1/num2;
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.divide(1,0)
        } catch (DivideToZero e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
