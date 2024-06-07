package users;

import core.Address;

public class Customer {

    private int ID;
    private String forename;
    private String surname;
    private Address address;
    private String username;
    private String password;

    public void setID(int id) {
        this.ID = id;
    }
    public void setForename(String forename) {
        this.forename = forename;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }
    public String getForename() {
        return forename;
    }
    public String getSurname() {
        return surname;
    }
    public Address getAddress() {
        return address;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
