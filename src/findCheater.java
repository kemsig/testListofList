import java.util.ArrayList;

public class findCheater {
    private ArrayList<ArrayList<String>> attendance;
    private int emailIndex;
    private int nameIndex;

    public findCheater (ArrayList<ArrayList<String>> a, int eI, int nI)
    {
        attendance = a;
        emailIndex = eI;
        nameIndex = nI;
    }

    public void frag()
    {
        //make another copy
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
        temp.addAll(attendance.get(emailIndex));


        for (int i = 0; i < temp.size(); i++)
        {
            String x = temp.get(i);
            temp.remove(x);
            if (temp.indexOf(x) != -1)
            {
                total.add(x);
            }
        }

        System.out.println("Oh my Science! ... Here is a list of cheaters: " + total);
    }
}
