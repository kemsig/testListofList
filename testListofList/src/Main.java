/* TODO LIST / BUG LIST
- if comma happens program dies (LITERALLY IT DOES)
- if someone puts a space then the program dies
- find the names of the poeple who did bad

- fucking make it so that if we get an IOException it will say it in the console
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // GUI stuff
        mainGUI GUI = new mainGUI();
        GUI.createFrame();

        //make csv methods
/*
        //write list
        makeCSV l1 = new makeCSV("E:\\IntelliJProjects\\testListofList\\csvs\\Grades 9-11 _ Bayanihan Attendance _ 2021-2022 - Total (1).csv");
        ArrayList<ArrayList<String>> students = l1.create();
        ArrayList<String> studentsVisual = l1.getVisual();
        System.out.println("Pick One (0-inf)" + studentsVisual);
        //compared list
        makeCSV l2 = new makeCSV("E:\\IntelliJProjects\\testListofList\\csvs\\Bayanihan Attendance Week 6 - 12_7-9_21 (Responses) - Form Responses 1.csv");
        ArrayList<ArrayList<String>> attend = l2.create();
        ArrayList<String> attendVisual = l2.getVisual();
        System.out.println("Pick One (0-inf)" + attendVisual);

        //compare methods (write list, index of write list, compared list, index of compared list)
        compareList compared = new compareList(students, 0, attend, 2);

        //write methods (visual, list of list, date)
        writeCSV testW = new writeCSV(studentsVisual, compared.compare(), "12/27/2021", "E:\\IntelliJProjects\\testListofList\\csvs\\out.csv");
        testW.createCSV();
        System.out.println("Undetected: " + compared.getUndetected());
        System.out.println("Unknown: " + compared.getUnknown());

        //finding the cheaters >:D
        //debug
        makeCSV emailDebug = new makeCSV("E:\\IntelliJProjects\\testListofList\\csvs\\emaildebug.csv");
        ArrayList<ArrayList<String>> edbg = emailDebug.create();
        findCheater detectEmail = new findCheater(edbg, 1, 0);
        detectEmail.frag();
*/


    }





}

