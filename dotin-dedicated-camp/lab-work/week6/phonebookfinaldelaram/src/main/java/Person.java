public class Person {
    private int id;
    private String name;
    private String family;
    private String phonenum;

    public Person(int id, String name, String family, String phonenum) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phonenum = phonenum;
    }
    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
