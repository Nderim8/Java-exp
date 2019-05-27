package phoneBook;


import java.util.ArrayList;


public class User {

    private String userName;
    private ArrayList<Entry> entriesArrayList;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEntrysArrayList(ArrayList<Entry> entriesArrayList) {
        this.entriesArrayList = entriesArrayList;
    }


    public ArrayList<Entry> getEntriesArrayList(){

        return this.entriesArrayList;

    }

  
}
