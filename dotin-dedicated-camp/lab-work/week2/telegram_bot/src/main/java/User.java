public class User extends Person implements Acts{

    public User(String name, String lastName, String userName) {
        super(name, lastName, userName);
    }

    //// TODO: 8/4/2021 complete functions
    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {}

    @Override
    public void select() {}

    @Override
    public void block(User user) {
        super.setStatus(true);
    }

    @Override
    public void unblock(User user) {
        super.setStatus(false);
    }
}
