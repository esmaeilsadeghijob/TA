public class Managment extends Person implements Acts{
    private int numOfAccessList = 3;
    private boolean[] accessList = new boolean[numOfAccessList];
    private String pass;

    public Managment(String name, String lastName, String userName, String pass) {
        super(name, lastName, userName);
        for (int i = 0; i < numOfAccessList; i++)
            accessList[i] = true;
        this.pass = pass;
        //// TODO: 8/4/2021 increase access modes
        //access0 = sendMsg
        //access1 = remove
        //access2 = mute
    }

    public void changeAccess(int index) {
        accessList[index] = !accessList[index];
    }

    @Override
    public void block(User user) {
        super.setStatus(true);
    }

    @Override
    public void unblock(User user) {
        super.setStatus(false);
    }

    //// TODO: 8/4/2021 complete functions
    @Override
    public void save() {}

    @Override
    public void delete() {}

    @Override
    public void update() {}

    @Override
    public void select() {}
}
