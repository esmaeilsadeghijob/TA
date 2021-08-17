package human;

import java.util.*;

public class Admin extends Person implements SpecialAbility{
    private String ADMINE = "Admin";
    private int password;

    public Admin(String firstName, String lastName, String userName, int phoneNumber, int password, String ADMINE) {
        super(firstName, lastName, userName, phoneNumber);
        this.password = password;
        this.ADMINE = ADMINE;
    }


    public String getADMINE() {
        return ADMINE;
    }

    public void setADMINE(String ADMINE) {
        this.ADMINE = ADMINE;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public void add(){
        ArrayList group = new ArrayList();
        group.add(this.getFirstName());
        group.add(this.getPhoneNumber());


        System.out.println(group);
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public void block() {
//        super.block();
        List blockInfo = new ArrayList();
        blockInfo.add(this.getPhoneNumber());

        System.out.println(blockInfo + "have blocked");
    }

    @Override
    public void unblock() {
//        super.unblock();
        ArrayList unblockInfo = new ArrayList();
        unblockInfo.add(this.getPhoneNumber());

        System.out.println(unblockInfo + "have unblocked");


    }


    @Override
    public String toString() {
        return "Admin{" +
                "ADMINE='" + ADMINE + '\'' +
                ", password=" + password +
                '}';
    }



}

