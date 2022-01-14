import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class makeCSV
{
    private String filePath;
    private ArrayList<String> visual;

    public makeCSV(String initFile)
    {
        filePath = initFile;
    }

    //for nowe it's a void, make it return a list of lists
    public ArrayList<ArrayList<String>> create()
    {
        ArrayList<ArrayList<String>> total = new ArrayList();
        String tempLines = "";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line1 = reader.readLine() + ",";
            String line = reader.readLine();
            while (line != null)
            {
                tempLines += line + ","; // put everything in a single line
                line = reader.readLine(); //statement ends i
            }

            ArrayList<String> tempList = new ArrayList<String>();
            while (tempLines.indexOf(",") != -1)
            {
                tempList.add(tempLines.substring(0, tempLines.indexOf(",")));
                tempLines = tempLines.substring(tempLines.indexOf(",")+1);
            }

            // adds the title line
            int m = 0;
            ArrayList<String> arrayVisual = new ArrayList<>();
            while (line1.indexOf(",") != -1)
            {
                arrayVisual.add(line1.substring(0, line1.indexOf(",")));
                line1 = line1.substring(line1.indexOf(",")+1);
                m++;
            }
            visual = arrayVisual;


            for (int i = 0; i < m; i++)
            {
                ArrayList<String> listStrings = new ArrayList<>();
                for (int x = i; x < tempList.size(); x +=m)
                    listStrings.add(tempList.get(x));
                total.add(listStrings);
            }

            reader.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();

        }

        return total;

    }

    public ArrayList<String> getVisual()
    {
        return visual;
    }

}