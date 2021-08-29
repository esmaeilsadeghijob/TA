public class Main {
    public static void main(String[] args) {
        MainImplementation food1 = new MainImplementation(15000, "pasta");
        System.out.println("name => " + food1.foodName());
        System.out.println("cost => " + food1.getPrice());
        System.out.println("new cost => " + food1.calculatePrice());

        System.out.println("--------------------");

        MainImplementation food2 = new MainImplementation(12000, "hotDog");
        System.out.println("name => " + food2.foodName());
        System.out.println("cost => " + food2.getPrice());
        System.out.println("new cost => " + food2.calculatePrice());
    }
}
