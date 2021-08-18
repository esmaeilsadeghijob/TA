public class Admin extends Person implements PersonAction{

    public Admin(long pid, String firstName, String lastName, String email, String phoneNumber, String username, String password, Role role) {
        super(pid, firstName, lastName, email, phoneNumber, username, password, role);
    }

    @Override
    public void block() {

    }

    @Override
    public void unBlock() {

    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void select() {

    }
}
