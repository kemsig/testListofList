//just in case i want to use this again

import java.util.ArrayList;

public class testMakeCSV {
    private ArrayList<ArrayList<String>> listOfLists;
    private ArrayList<String> list;

    public testMakeCSV(ArrayList<ArrayList<String>> lolIn, ArrayList<String> lIn) {
        listOfLists = lolIn;
        list = lIn;

    }

    public ArrayList<ArrayList<String>> combine()
    {
        listOfLists.add(list);
        return listOfLists;

    }

}
