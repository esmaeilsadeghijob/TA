package homeworks;

public class Dog implements Animal{
    @Override
    public void move() {
        System.out.println("The dog is running...");
    }

    @Override
    public void talk() {
        System.out.println("The dog says Hop Hop!");
    }

    @Override
    public String toString() {
        return "this is a dog class";
    }
}
