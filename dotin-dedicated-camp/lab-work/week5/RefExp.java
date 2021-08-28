public class RefExp {

    private String name;
    private String lastName;

    public void print() {
        System.out.println(name + lastName);
    }

    public void bye(String s) {
        System.out.println(s);
        System.out.println("don't be annoying get out of here.");
    }

    @Override
    public String toString() {
        return "RefExp{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
