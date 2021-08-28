package mrfnBot;

import java.util.Objects;

public abstract class Person {
    private String name;
    private String family;
    private String username;
    private long id;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(String name, String family, String username, long id) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
