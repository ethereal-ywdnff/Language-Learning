package assignment;

public class Customer {

    private int ID;
    private String forename;
    private String surname;
    private String houseNumber;
    private String postcode;
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
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
    public String getHouseNumber() {
        return houseNumber;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
