package human;



import java.util.*;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String userName;
    private int phoneNumber;

    public Person(String firstName, String lastName, String userName, int phoneNumber) {
        this.firstName = firstName;
        this.userName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void save(){
        List saveInfo = new ArrayList();
        saveInfo.add(this.getFirstName());
        saveInfo.add(this.getLastName());
        saveInfo.add(this.getUserName());
        saveInfo.add(this.getPhoneNumber());


        System.out.println("Contacts info : " + saveInfo);
    }
    public void delete(){
        ArrayList deleteFromPhonBook = new ArrayList();
        deleteFromPhonBook.add(this.getFirstName());
        deleteFromPhonBook.add(this.getLastName());
        deleteFromPhonBook.add(this.getUserName());
        deleteFromPhonBook.add(this.getPhoneNumber());


        System.out.println(deleteFromPhonBook);

    }
    public void block(){
        ArrayList blockInfoFromphonBook = new ArrayList();
        blockInfoFromphonBook.add(this.getPhoneNumber());

        System.out.println(blockInfoFromphonBook);

    }
    public void unblock(){
        ArrayList unblockInfoFromphonebook = new ArrayList();
        unblockInfoFromphonebook.add(this.getPhoneNumber());


    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

