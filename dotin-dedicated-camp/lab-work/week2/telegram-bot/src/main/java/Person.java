public abstract class Person {

    private long pid;
    private String firstName;
    private String lastName;
    private String Email;
    private String phoneNumber;
    private String username;
    private String password;
    private Role role;

    public Person(long pid, String firstName, String lastName, String email, String phoneNumber, String username, String password, Role role) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void save(Person person);
    public abstract void delete(Person person);
    public abstract void update(Person person);
    public abstract void select();

}
