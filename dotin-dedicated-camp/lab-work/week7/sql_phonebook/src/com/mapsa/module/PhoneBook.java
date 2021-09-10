package com.mapsa.module;

import com.mapsa.crud_to_db.ContactTableCrud;
import com.mapsa.crud_to_db.PhoneTableCrud;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private ContactTableCrud contactTable;
    private PhoneTableCrud phoneTable;
    private Scanner scanner;

    public PhoneBook() {
        contactTable = new ContactTableCrud();
        phoneTable = new PhoneTableCrud();
        scanner = new Scanner(System.in);
        System.out.println("Hi Welcome to your phonebook Fatemeh :)");
    }

    public int getMenuOp() {
        System.out.println("Menu:\n1.enter a new contact\n2.add a phone number for contact\n" +
                "3.edit contact\n4.edit phone number\n5.show contact info\n6.show all contacts\n" +
                "7.delete contact\n8.delete phone number\n9.exit\n(press in program 0 for back)");
        int op = scanner.nextInt();
        return op;
    }

    private void editFirstName(Contact contact) {
        System.out.print("enter your contact new name(press 0 to skip): ");
        String firstname = scanner.next();
        contact.setFirstname(firstname.equals("0") ? contact.getFirstname() : firstname);
    }

    private void editLastName(Contact contact) {
        System.out.print("enter your contact new last name(press 0 to skip): ");
        String lastName = scanner.next();
        contact.setLastname(lastName.equals("0") ? contact.getLastname() : lastName);
    }

    private void editContactId(Contact contact, int contactId) throws SQLException {
        String infoMsg = "enter your contact new id(press 0 to skip): ";
        String errMsg = "duplicate id. try again!";
        int id = getContactId(infoMsg, errMsg, false);
        contact.setId((id == 0) ? contact.getId() : id);
        List<Phone> phones = phoneTable.findAll(contactId);
        for (Phone phone: phones) {
            phone.setContactId(id);
            phoneTable.update(phone);
        }
    }

    private int getContactId(String infoMessage, String errorMessage, boolean available) throws SQLException {
        System.out.print(infoMessage);
        int contactId = scanner.nextInt();
        while (available == (contactTable.findById(contactId) == null)) {
            if (contactId == 0)
                return 0;
            System.out.println(errorMessage);
            System.out.print(infoMessage);
            contactId = scanner.nextInt();
        }
        return contactId;
    }

    private String getPhoneNumber(String infoMessage, String errorMessage, boolean available) throws SQLException {
        System.out.print(infoMessage);
        String phoneNumber = scanner.next();
        while (available == (phoneTable.findById(phoneNumber) == null)) {
            if (phoneNumber.equals("0"))
                return "0";
            System.out.println(errorMessage);
            System.out.print(infoMessage);
            phoneNumber = scanner.next();
        }
        return phoneNumber;
    }

    public void addNewContact() throws SQLException {
        System.out.print("enter your contact name: ");
        String firstname = scanner.next();
        System.out.print("enter your contact last name(press 0 to skip): ");
        String lastName = scanner.next();
        if (lastName.equals("0"))
            lastName = "";
        String infoMsg = "enter an id for your contact: ";
        String errMsg = "duplicate id. try again!";
        int id = getContactId(infoMsg, errMsg, false);
        if (id == 0) return;

        Contact newContact = new Contact(id, firstname, lastName);
        contactTable.save(newContact);
        System.out.println("new contact added!");
    }

    public void addPhoneNumber() throws SQLException {
        String infoMsg = "enter your contact id: ";
        String errMsg = "invalid id!";
        int contactId = getContactId(infoMsg, errMsg, true);
        if (contactId == 0) return;

        infoMsg = "enter the phone number: ";
        errMsg = "duplicate phone number. try again!";
        String phoneNumber = getPhoneNumber(infoMsg, errMsg, false);
        if (phoneNumber.equals("0")) return;

        Phone newPhone = new Phone(contactId, phoneNumber);
        phoneTable.save(newPhone);
        System.out.println("new number added!");
    }

    public void editContact() throws SQLException {
        String infoMsg = "enter your contact id: ";
        String errMsg = "invalid id!";
        int contactId = getContactId(infoMsg, errMsg, true);
        if (contactId == 0) return;

        Contact contact = contactTable.findById(contactId);
        editFirstName(contact);
        editLastName(contact);
        editContactId(contact, contactId);
        contactTable.update(contact);
        System.out.println("contact edited!");
    }

    public void editPhoneNumber() throws SQLException {
        String infoMsg = "enter your phone number: ";
        String errMsg = "invalid phone number!";
        String phoneNumber = getPhoneNumber(infoMsg, errMsg, true);
        if (phoneNumber.equals("0")) return;

        Phone phone = phoneTable.findById(phoneNumber);

        infoMsg = "enter new phone number: ";
        errMsg = "duplicate phone number. try again!";
        String newNumber = getPhoneNumber(infoMsg, errMsg, false);
        if (newNumber.equals("0")) return;

        phone.setPhoneNumber(newNumber);
        phoneTable.update(phone);
        System.out.println("phone number edited!");
    }

    public void showContactInfo() throws SQLException {
        String infoMsg = "enter your contact id(0 for skip): ";
        String errMsg = "invalid id!";
        int contactId = getContactId(infoMsg, errMsg, true);
        if (contactId == 0) return;

        Contact contact = contactTable.findById(contactId);
        List<Phone> phones = phoneTable.findAll(contactId);
        for (Phone phone:phones)
            contact.addPhone(phone);
        System.out.println(contact.toString());
    }

    public void showAllContacts() throws SQLException {
        List<Contact> contacts = contactTable.findAll();
        if (contacts.isEmpty()) {
            System.out.println("phonebook is empty!");
            return;
        }
        int index = 1;
        for (Contact contact:contacts)
            System.out.println((index++) + "." + contact.toString());
    }

    public void deleteContact() throws SQLException {
        String infoMsg = "enter your contact id: ";
        String errMsg = "invalid id!";
        int contactId = getContactId(infoMsg, errMsg, true);
        if (contactId == 0) return;

        Contact contact = contactTable.findById(contactId);
        contactTable.delete(contact);
        List<Phone> phones = phoneTable.findAll(contactId);
        for (Phone phone:phones)
            phoneTable.delete(phone);
        System.out.println("contact deleted!");
    }

    public void deletePhone() throws SQLException {
        String infoMsg = "enter your phone number: ";
        String errMsg = "invalid phone number!";
        String phoneNumber = getPhoneNumber(infoMsg, errMsg, true);
        if (phoneNumber.equals("0")) return;

        Phone phone = phoneTable.findById(phoneNumber);
        phoneTable.delete(phone);
        System.out.println("phone number deleted!");
    }
}
