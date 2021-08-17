public abstract class User extends Person implements PersAct{


    @Override
    public abstract String register(String un, String pw, String n);

    @Override
    public abstract String delete(String un, String pw);

    @Override
    public abstract String save(String un, String pw);

    @Override
    public abstract void block();
    @Override
    public abstract void unblock();
    @Override
    public abstract void report();


}