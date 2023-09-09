package day_six;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class day_six {
    static String filePath = "AdventOfCode2022/day_six/data/input.txt";
    static File file = new File(filePath);
    static Scanner scr;
    static String st;
    static ArrayList<Character> marker;

    public static void LookForMarker(int markerLength) {
        while (scr.hasNextLine()) {
            st = scr.nextLine();
            int count = 0;
            int dupe = 0;
            marker = new ArrayList<Character>();
                for (int i = 0; i < st.length(); i++){
                    marker.add(st.charAt(i));
                    count++;
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
                        if(dupe > 0){
                            marker.remove(0);
                        } else { 
                            System.out.println(marker);
                            System.out.println("First marker is at position: " + count);
                            break;
                        }
                        dupe = 0;
                    }
                }   
            }
    }

    public static void main(String[] args) {
        LookForMarker(4);
        LookForMarker(14);
    }
    
}