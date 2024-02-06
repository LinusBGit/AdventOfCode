package day_six;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class day_six {
    static String filePath = "day_six/data/input.txt";
    static File file = new File(filePath);
    static Scanner scr;
    static String st;
    static ArrayList<Character> marker;

    // Method that looks for input parameter value markerLength unique characters in a row
    public static void LookForMarker(int markerLength) {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scr.hasNextLine()) {
            st = scr.nextLine();
            int count = 0;
            int dupe = 0;
            marker = new ArrayList<Character>();
            // Add characters to ArrayList until it reaches input parameter value markerLength
                for (int i = 0; i < st.length(); i++){
                    marker.add(st.charAt(i));
                    count++;
                    // Once it reaches markerLength value check for duplicate characters
                    if(count >= markerLength){
                        dupeLoop:
                            for(int j = 0; j < markerLength; j++){
                                for(int k = j + 1; k < markerLength; k++){
                                    if(marker.get(j) == marker.get(k)) {
                                        dupe++;
                                        break dupeLoop;
                                    }
                                }
                            }
                        // If duplicate characters were found
                        if(dupe > 0){
                            marker.remove(0);
                        } 
                        // If no duplicate characters were found
                        else { 
                            System.out.println(marker);
                            System.out.println("First marker is at position: " + count);
                            break;
                        }
                        dupe = 0;
                    }
                }   
            }
            marker.clear();
    }

    public static void main(String[] args) {
        LookForMarker(4);
        LookForMarker(14);
    }
}