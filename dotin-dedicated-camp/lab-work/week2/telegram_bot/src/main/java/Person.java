public abstract class Person {
    private String name;
    private String lastName;
    private String userName;
    private boolean status = false; // not block

    public Person(String name, String lastName, String userName) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
    }

    public abstract void save();
    public abstract void delete();
    public abstract void update();
    public abstract void select();

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

