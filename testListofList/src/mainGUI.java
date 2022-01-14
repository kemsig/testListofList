import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainGUI {

    private JPanel mainPanel;
    private JPanel argPanel;

    private JTextField fp1;
    private JTextField fp2;
    private JComboBox combStart;
    private JButton startButton;
    private JTextPane textConsole;

    private JLabel lbl1;
    private JLabel lbl2;
    private JButton calibratePathSButton;
    private JTextField outPath;
    private JLabel outText;
    private JButton compareButton;
    private JPanel comparePanel;
    private JTextField index2TF;
    private JTextField index1TF;
    private JTextField dateTF;
    private JTextField emailTF;

    private String calibrationText;
    private String filepath1;
    private String filepath2;
    private String oPath;

    private makeCSV makeP1;
    private makeCSV makeP2;
    private ArrayList<ArrayList<String>> p1LOL;
    private ArrayList<ArrayList<String>> p2LOL;
    private compareList compare;

    private int TF_IN_1;
    private int TF_IN_2;
    private int TF_IN_E;

    public mainGUI() {
        startButton.addActionListener(new ActionListener() {
            //Get Index, List Unknown, List Unchecked, List Cheaters
            @Override
            public void actionPerformed(ActionEvent e) {
                if (combStart.getSelectedItem().equals("Get Index"))
                {
                    String add = "\n\nHOW TO: Put the index (from 0-infinity) in the text-boxes then you can compare, each item is separated by a comma.\nFile Path 1 Index's (0 - infinity): " + makeP1.getVisual() + "\nFile Path 2 Index's (0 - infinity): " + makeP2.getVisual();
                    if (!(calibrationText.contains(add)))
                        calibrationText += add;
                    textConsole.setText(calibrationText);
                }
                else if (combStart.getSelectedItem().equals("List Unknown"))
                {
                    String add = "\n\nList of Unknown (didn't find them): " + compare.getUnknown();
                    if (!(calibrationText.contains(add)))
                        calibrationText += add;
                    textConsole.setText(calibrationText);
                }
                else if (combStart.getSelectedItem().equals("List Unchecked"))
                {
                    String add = "\n\nList of Unchecked: " + compare.getUndetected();
                    if (!(calibrationText.contains(add)))
                        calibrationText += add;
                    textConsole.setText(calibrationText);
                }
                else if (combStart.getSelectedItem().equals("List Cheaters"))
                {
                    findCheater frag = new findCheater(p2LOL, TF_IN_E, TF_IN_2);
                    frag.frag();
                    String add = "\n\nList of Cheaters: ";
                    if (!(calibrationText.contains(add)))
                        calibrationText += add;
                    textConsole.setText(calibrationText);
                }
            }
        });
        calibratePathSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(fp1.getText().equals("") || fp2.getText().equals("") || outPath.getText().equals("")))
                {
                    filepath1 = fp1.getText();
                    filepath2 = fp2.getText();
                    oPath = outPath.getText();
                    compareButton.setEnabled(true);
                    index1TF.setEnabled(true);
                    index2TF.setEnabled(true);
                    combStart.setEnabled(true);
                    startButton.setEnabled(true);

                    calibrationText = "File Path's Calibrated\nFile Path 1: " + filepath1 + "\nFile Path 2: " + filepath2 + "\nOutput Path: " + oPath;
                    textConsole.setText(calibrationText);
                    //create the CSV's
                    makeP1 = new makeCSV(filepath1);
                    makeP2 = new makeCSV(filepath2);
                    p1LOL = makeP1.create();
                    p2LOL = makeP2.create();

                }
                else
                {
                    calibrationText = "File Path Calibration Failed.";
                    textConsole.setText(calibrationText + "\nPlease input the File Path's in the text boxes.");
                }
            }
        });
        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(index1TF.getText().equals("") || index1TF.getText().equals("") || dateTF.getText().equals("") || emailTF.getText().equals("")))
                {
                    TF_IN_1 = Integer.parseInt(index1TF.getText());
                    TF_IN_2 = Integer.parseInt(index2TF.getText());
                    TF_IN_E = Integer.parseInt(emailTF.getText());
                    if (TF_IN_1 > -1 && TF_IN_2 > -1)
                    {
                        compare = new compareList(p1LOL, TF_IN_1, p2LOL, TF_IN_2);
                        writeCSV write = new writeCSV(makeP1.getVisual(), compare.compare(), dateTF.getText(), oPath);
                        write.createCSV();
                        String add = "\n\nFile Writing and Comparison has completed, check out.csv";
                        if (!(calibrationText.contains(add)))
                            calibrationText += add;
                        textConsole.setText(calibrationText);

                    }

                }



            }
        });
    }

    public void createFrame()
    {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setContentPane(mainPanel);
        frame.setVisible(true);


        textConsole.setText("Please input the File Path's.");
    }
}
