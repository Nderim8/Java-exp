package databaseLayer;

import databaseLayer.*;
import entity.PhoneBook;

import java.util.ArrayList;

/**
 * Created by Ornela on 05/12/2017.
 */
public class PhoneBookTransaction {

    public void savePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        for (PhoneBook phoneBook : phoneBooks) {
            validateBeforeSave(phoneBook);
        }
        getNewPhoneBookDAO().insert(phoneBooks);
        commit();
    }

    public void updatePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        for (PhoneBook phoneBook : phoneBooks) {
            validateBeforeUpdate(phoneBook);
        }
        getNewPhoneBookDAO().update(phoneBooks);
        commit();
    }


    public void deletePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        getNewPhoneBookDAO().delete(phoneBooks);
        commit();
    }

    public ArrayList<PhoneBook> getPhoneBooks(String firstName, String lastName) throws Exception {
        return getNewPhoneBookDAO().select(firstName, lastName);
    }

    private PhoneBookDAO getNewPhoneBookDAO() {
        return new PhoneBookDAO();
    }


    public void commit() throws Exception {
        Container.getInstance().commitObjects();
    }

    private void validateBeforeUpdate(PhoneBook phoneBook) throws Exception {
        validateBeforeSave(phoneBook);
        String id = phoneBook.getId();
        if (id == null || id.isEmpty()) {
            throw new Exception("MissingId");
        }
    }

    private void validateBeforeSave(PhoneBook phoneBook) throws Exception {
        String firstName = phoneBook.getFirstName();
        if (firstName == null || firstName.isEmpty()) {
            throw new Exception("MissingFirstName");
        }
        String lastName = phoneBook.getLastName();
        if (lastName == null || lastName.isEmpty()) {
            throw new Exception("MissingLastName");
        }
        String typeOfNumber = phoneBook.getTypeOfNumber();
        if (typeOfNumber == null || typeOfNumber.isEmpty()) {
            throw new Exception("MissingTypeOfNumber");
        }
        String number = phoneBook.getNumber();
        if (number == null || number.isEmpty()) {
            throw new Exception("MissingNumber");
        }
    }
}
