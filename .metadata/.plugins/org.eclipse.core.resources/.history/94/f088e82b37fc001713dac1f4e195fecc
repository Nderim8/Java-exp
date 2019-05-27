package entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import databaseLayer.PhoneBookDAO;
import databaseLayer.PhoneBookTransaction;

import java.util.ArrayList;

/**
 * Created by Ornela on 05/12/2017.
 */
public class PhoneBookManager {

    public void savePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        getNewPhoneBookTransaction().savePhoneBooks(phoneBooks);
    }

    public void savePhoneBook(PhoneBook phoneBook) throws Exception {
        ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
        list.add(phoneBook);
        savePhoneBooks(list);
    }

    public void updatePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        getNewPhoneBookTransaction().updatePhoneBooks(phoneBooks);
    }

    public void updatePhoneBook(PhoneBook phoneBook) throws Exception {
        ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
        list.add(phoneBook);
        updatePhoneBooks(list);
    }


    public void deletePhoneBooks(ArrayList<PhoneBook> phoneBooks) throws Exception {
        getNewPhoneBookTransaction().deletePhoneBooks(phoneBooks);
    }

    public void deletePhoneBook(PhoneBook phoneBook) throws Exception {
        ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
        list.add(phoneBook);
        deletePhoneBooks(list);
    }

    public ArrayList<PhoneBook> getPhoneBooks(String firstName, String lastName) throws Exception {
        return getNewPhoneBookTransaction().getPhoneBooks(firstName, lastName);
    }

    private PhoneBookTransaction getNewPhoneBookTransaction() {
        return new PhoneBookTransaction();
    }

    public String getPhoneBooksAsJson(String firstName, String lastName) throws Exception {
        ArrayList<PhoneBook> list = getPhoneBooks(firstName, lastName);
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return String.valueOf(gson.toJsonTree(list));
    }

}
