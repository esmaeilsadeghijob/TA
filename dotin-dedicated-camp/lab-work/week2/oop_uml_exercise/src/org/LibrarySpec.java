package org;

public abstract class LibrarySpec {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void searchBook(String nameBook,String nameAuthor);
    public abstract void lendingBook(String nameBook,String nameAuthor);
    public abstract void returnBook(String nameBook,String nameAuthor);
    public abstract void payFines();
    public abstract void memberRegister(String name,String family,String nationalCode,String address,String username,String password);
    public abstract void verifyMember(String username,String password);
    public abstract void issueIdCard();
}
