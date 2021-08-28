import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        City.Person person1 = new City.Person("fatemeh", "batooei", 26, "tehranpars");
        City.Person person2 = new City.Person("zahra", "tabrizi", 24, "narmak");
        City.Person person3 = new City.Person("sara", "heydari", 28, "azadi");

        City city1 = new City();
        city1.setName("tehran");
        city1.setPopulation(8000000);
        city1.setPersonList(Arrays.asList(person1, person2, person3));

        for (City.Person person : city1.getPersonList()) {
            System.out.println("name: " + person.getName());
            System.out.println("family: " + person.getFamily());
            System.out.println("age: " + person.getAge());
            System.out.println("address: " + person.getAddress());
            System.out.println("*******************");
        }
    }
}
