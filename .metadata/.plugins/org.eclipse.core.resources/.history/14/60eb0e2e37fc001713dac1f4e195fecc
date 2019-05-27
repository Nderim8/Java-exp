package databaseLayer;

import entity.PhoneBook;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ornela on 05/12/2017.
 */
public class PhoneBookDAO {

    public void insert(ArrayList<PhoneBook> phoneBooks) throws Exception {
        ArrayList<PhoneBook> objects = Container.getInstance().getObjects();
        for (PhoneBook phoneBook : phoneBooks) {
            String firstLastName = phoneBook.getFirstName() + "" + phoneBook.getLastName();
            int indexToAdd = 0;
            int size = objects.size();
            for (int index = 0; index < size; index++) {
                indexToAdd = index;
                PhoneBook phoneBookTmp = objects.get(index);
                String firstLastNameTmp = phoneBookTmp.getFirstName() + "" + phoneBookTmp.getLastName();
                int compareValue = firstLastName.compareTo(firstLastNameTmp);
                if (compareValue == -1 || compareValue == 0) {
                    break;
                }
                indexToAdd += 1;
            }
            phoneBook.setId(generateUniqueId());
            if (indexToAdd == size) {
                objects.add(phoneBook);
            } else {
                objects.add(indexToAdd, phoneBook);
            }
        }
    }

    public void update(ArrayList<PhoneBook> phoneBooks) throws Exception {
        ArrayList<PhoneBook> objects = Container.getInstance().getObjects();
        for (PhoneBook phoneBook : phoneBooks) {
            int index = objects.indexOf(phoneBook);
            if (index != -1) {
                objects.remove(index);
            }
        }
        insert(phoneBooks);
    }

    public void delete(ArrayList<PhoneBook> phoneBooks) throws Exception {
        ArrayList<PhoneBook> objects = Container.getInstance().getObjects();
        for (PhoneBook phoneBook : phoneBooks) {
            objects.remove(objects);
        }
    }

    public ArrayList<PhoneBook> select(String firstName, String lastName) throws Exception {
        ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
        ArrayList<PhoneBook> objects = Container.getInstance().getObjects();
        for (PhoneBook phoneBook : objects) {
            String firstNameTmp = phoneBook.getFirstName();
            String lastNameTmp = phoneBook.getLastName();
            if (firstNameTmp.equals(firstName) && lastNameTmp.equals(lastName)) {
                list.add((PhoneBook) phoneBook.clone());
            }
        }
        return list;
    }

    private String generateUniqueId() throws InterruptedException {
        return  UUID.randomUUID().toString();
    }

}
