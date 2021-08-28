public class Person {

    public String Name;
    public int salary;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String position(int a) {
        if (a < 500) {
            return "worker";
        } else {

            return "manager";
        }

    }

    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person.position(500));
    }
}