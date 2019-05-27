package databaseLayer;

import entity.PhoneBook;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ornela on 05/12/2017.
 */
public class Container {
    private static Container instance;
    private ArrayList<PhoneBook> objects = new ArrayList<PhoneBook>();

    private Container() throws Exception {
        loadData();
    }

    public static synchronized Container getInstance() throws Exception {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public ArrayList<PhoneBook> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<PhoneBook> objects) {
        this.objects = objects;
    }

    public void commitObjects() throws Exception {
        saveOnFile(getObjects());
    }

    private void saveOnFile(ArrayList list) throws Exception {

        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream("data.ornela");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadData() throws Exception {
        try {
            loadObjectsFromFile();
        } catch (Exception e) {
            setObjects(new ArrayList<PhoneBook>());
            commitObjects();
        }
    }

    private void loadObjectsFromFile() throws Exception {

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream("data.ornela");
            ois = new ObjectInputStream(fin);
            setObjects((ArrayList<PhoneBook>) ois.readObject());

        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
