package homeworks;

public class Cat implements Animal{
    @Override
    public void move() {
        System.out.println("The cat is running...");
    }

    @Override
    public void talk() {
        System.out.println("The cat says meow!");
    }

    @Override
    public String toString() {
        return "this is a cat class";
    }
}
