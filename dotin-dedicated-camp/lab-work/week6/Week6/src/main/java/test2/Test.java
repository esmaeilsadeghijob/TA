package test2;

@FunctionalInterface
public interface Test {

    void t();
    default void tt() {
        System.out.println("idk");
    }
}
