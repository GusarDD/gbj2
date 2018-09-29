package Task3;

public class Abonent {
    private String surename;
    private Integer phoneNumber;

    Abonent(Integer phoneNumber, String surename) {
        this.surename = surename;
        this.phoneNumber = phoneNumber;
    }

    public String getSurename() {
        return surename;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }
}
