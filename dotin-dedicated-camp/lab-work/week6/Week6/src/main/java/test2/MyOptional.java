package test2;

import java.util.Optional;

public class MyOptional {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        MyOptional o = new MyOptional();
        o.setName("");
        if (o.getName().equals("")) {
            System.out.println("this is null.");
        }
        Optional<String> optional = Optional.ofNullable(o.getName());
        optional.ifPresent(s -> {
            if (o.getName().equals("")) {
                System.out.println("this is null.");
            }
        });
    }
}
