package entity;

import java.io.Serializable;

/**
 * Created by Ornela on 05/12/2017.
 */
public class PhoneBook implements Serializable, Cloneable {
    public static final String TYPE_OF_NUMBER_WORK = "WORK";
    public static final String TYPE_OF_NUMBER_CELLPHONE = "CELL PHONE";
    public static final String TYPE_OF_NUMBER_HOME = "HOME";

    private String id = "";
    private String firstName = "";
    private String lastName = "";
    private String typeOfNumber = "";
    private String number = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTypeOfNumber() {
        return typeOfNumber;
    }

    public void setTypeOfNumber(String typeOfNumber) {
        this.typeOfNumber = typeOfNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBook phoneBook = (PhoneBook) o;

        return id == phoneBook.id;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typeOfNumber=" + typeOfNumber +
                ", number='" + number + '\'' +
                '}';
    }
}

