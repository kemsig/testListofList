import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class writeCSV
{
    private ArrayList<String> visual;
    private ArrayList<ArrayList<String>> listOfList;
    private String date;
    private String out;

    public writeCSV(ArrayList<String> v, ArrayList<ArrayList<String>> s, String d, String o)
    {
        visual = v;
        listOfList = s;
        date = d;
        out = o;
    }

    public void createCSV()
    {
        try (PrintWriter writer = new PrintWriter(out)) {

            StringBuilder sb = new StringBuilder();

            //put the title stuff on the the front
            String temp1 = "";
            for (int i = 0; i < visual.size(); i++)
                temp1 += visual.get(i) + ",";
            sb.append(temp1.substring(0, temp1.length()-1));
            sb.append("," + date);
            sb.append('\n');

            for (int i = 0; i < listOfList.get(0).size(); i++)
            {
                String temp2 = "";
                for (int x = 0; x < listOfList.size(); x++)
                {
                    temp2 += listOfList.get(x).get(i) + ",";

                    //System.out.println(listOfList.get(x).get(i));
                    //sb.append(listOfList.get(x).get(i) + ",");
                }
                sb.append(temp2.substring(0, temp2.length()-1));
                sb.append('\n');
            }


            writer.write(sb.toString());

            System.out.println("Writing has finished");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}