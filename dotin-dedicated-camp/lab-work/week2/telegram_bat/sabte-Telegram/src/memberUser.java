public class memberUser extends person implements user{

    private String username;
    @Override
    public void delete() {

    }

    @Override
    public void save() {

    }

    @Override
    public void add() {

    }

    @Override
    public void select() {

    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String sendText(String text) {
        return text;
    }

    public void deleteText(String text) {

    }
}
