public class Calculator<C> {
    private C a;
    private C b;

    public C getA() {
        return a;
    }

    public void setA(C a) {
        this.a = a;
    }

    public C getB() {
        return b;
    }

    public void setB(C b) {
        this.b = b;
    }

    public void add(C a, C b) {
    }

    public void sub(C a, C b) {
    }

    public void multi(C a, C b) {
    }

    public void div(C a, C b) {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(5,6);
        calculator.sub(10.2,5);
        calculator.multi(3.5,7.5);
        calculator.div(5, 3.5);
    }

}
