public class Admin extends Person implements Acts{
    private int numOfAccessList = 3;
    private boolean[] accessList = new boolean[numOfAccessList];

    public Admin(String name, String lastName, String userName) {
        super(name, lastName, userName);
        for (int i = 0; i < numOfAccessList; i++) {
            accessList[i] = true;
        }
        //// TODO: 8/4/2021 increase access modes
        //access0 = sendMsg
        //access1 = remove
        //access2 = mute
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
