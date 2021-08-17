public abstract class ComputerAbs implements Computer {

    public abstract String sayHello();

    @Override
    public long fact(int n) {
        if (n == 0)
            return 1;
        else
            return (n * fact (n - 1));
    }
}


