public abstract class Person {
    private String username;
    private String password;
    public String name;


    public void setusername(String username){
        this.username=username;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }

    public abstract String register(String un, String pw,String n);
    public abstract String save(String un, String pw);
    public abstract String delete(String un, String pw);
    public abstract String update(String un);

    public abstract void report();
}
