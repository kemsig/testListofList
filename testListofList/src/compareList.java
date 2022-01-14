import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class compareList {
    private ArrayList<ArrayList<String>> writeList;
    private ArrayList<ArrayList<String>> alist2;
    private int index1;
    private int index2;

    private ArrayList<String> undetected;
    private ArrayList<String> unkown;

    public compareList (ArrayList<ArrayList<String>> iwriteList, int i1, ArrayList<ArrayList<String>> ialist2, int i2)
    {
        writeList = iwriteList;
        alist2 = ialist2;
        index1 = i1;
        index2 = i2;
    }

    public ArrayList<ArrayList<String>> compare()
    {
        ArrayList<ArrayList<String>> total = new ArrayList<>();
        total = writeList;
        //setup templist
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < writeList.get(0).size(); i++)
        {
            tempList.add("");
        }
        //finds the names in writelist
        ArrayList<String> checkedNames = new ArrayList<>();
        for (int i = 0; i < writeList.get(index1).size(); i++)
        {
            //finds the names in the other list
            for (int x = 0; x < alist2.get(index2).size(); x++)
            {
                //this checks if both names are the same
                if (writeList.get(index1).get(i).equals(alist2.get(index2).get(x)))
                {
                    checkedNames.add(writeList.get(index1).get(i));
                }
                else if (writeList.get(index1).get(i).equalsIgnoreCase(alist2.get(index2).get(x)))
                {
                    checkedNames.add(writeList.get(index1).get(i));
                    alist2.get(index2).set(x, writeList.get(index1).get(i));
                }
            }
        }
        ArrayList<String> notChecked = new ArrayList<>();
        //ArrayList<String> tempList3 = tempList;
        notChecked.addAll(writeList.get(index1));

        for (int i = 0; i < checkedNames.size(); i++)
        {
            int x = writeList.get(index1).indexOf(checkedNames.get(i));
            notChecked.remove(checkedNames.get(i));
            tempList.set(x, "x");
        }

        undetected = notChecked;

        ArrayList<String> currentUnknown = new ArrayList<>();
        ArrayList<String> tempList2 = new ArrayList<>();
        currentUnknown.addAll(alist2.get(index2));
        tempList2.addAll(checkedNames);
        tempList2.addAll(notChecked);
        for (int i = 0; i < tempList2.size(); i++)
        {
            currentUnknown.remove(tempList2.get(i));
        }
        unkown = currentUnknown;

        total.add(tempList);
        System.out.println("Compare has finished.");
        return total;

    }

    //gets the people who weren't detected
    public ArrayList<String> getUndetected()
    {
        return undetected;
    }

    //gets the missing Names from the original list
    public ArrayList<String> getUnknown()
    {
        return unkown;
    }



}
