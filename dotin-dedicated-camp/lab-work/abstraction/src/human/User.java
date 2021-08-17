
package human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User extends Person implements GeneralAbility{
    private int id;


    public User(String firstName, String lastName, String userName, int phoneNumber,int id) {

        super(firstName, lastName, userName, phoneNumber);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void save() {
        super.save();
        List saveContactToNotebook =new ArrayList();
        saveContactToNotebook.add(this.getFirstName());
        saveContactToNotebook.add(this.getPhoneNumber());
        saveContactToNotebook.add(this.id);


        System.out.println(saveContactToNotebook);
    }

    @Override
    public void block() {
        ArrayList blockFromContacts= new ArrayList();
        blockFromContacts.add(this.getPhoneNumber());


        System.out.println(blockFromContacts + "have blocked");
    }

    @Override
    public void unblock() {
        List unblockFromContacts= new ArrayList();
        unblockFromContacts.add(this.getPhoneNumber());

        System.out.println(unblockFromContacts + "have blocked");
    }




    @Override
    public void read() {
        System.out.println("can read messages");
    }

    @Override
    public void comments() {
        System.out.println("can comment for messages");
    }
}
