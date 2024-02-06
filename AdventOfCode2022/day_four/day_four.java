package day_four;

import java.io.*;
import java.util.Scanner;

public class day_four {

    static String filePath = "day_four/data/input.txt";
    static File file = new File(filePath);
    static Scanner scr;
    static String st;
    static int fElfStart;
    static int fElfEnd;
    static int sElfStart;
    static int sElfEnd;

    // First part of the challenge
    public static void part1() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;

        while (scr.hasNextLine()) {
            st = scr.nextLine();
            // Change data format from "x-y,z-p" to "x-y-z-p"
            st = st.replace(",", "-");
            // Split at every "-" and store in array
            String[] parts = st.split("\\-");
            // Assign each value to an integer we can compare
            fElfStart = Integer.parseInt(parts[0]);
            fElfEnd = Integer.parseInt(parts[1]);
            sElfStart = Integer.parseInt(parts[2]);
            sElfEnd = Integer.parseInt(parts[3]);

            // Check if one elf's cleaning duties fully contains the other elf's assigned areas by checking
            // if the starting area is the same or a lower number and ending area is the same or a higher number
            if ((fElfStart <= sElfStart && fElfEnd >= sElfEnd) || (sElfStart <= fElfStart && sElfEnd >= fElfEnd)) {
                count++;
            }
        }
        System.out.println(count);
        scr.close();
    }

    // Second part of the challenge
    public static void part2() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;

        while (scr.hasNextLine()) {
            st = scr.nextLine();
            // Change data format from "x-y,z-p" to "x-y-z-p"
            st = st.replace(",", "-");
            String[] parts = st.split("\\-");
            // Assign each value to an integer we can compare
            fElfStart = Integer.parseInt(parts[0]);
            fElfEnd = Integer.parseInt(parts[1]);
            sElfStart = Integer.parseInt(parts[2]);
            sElfEnd = Integer.parseInt(parts[3]);

            // Check if any of the pairs have overlapping areas at all (do not have to be fully overlapped)
            if ((fElfStart <= sElfEnd && fElfEnd >= sElfStart) ||
                    (sElfStart <= fElfEnd && sElfEnd >= fElfStart))
                count++;

        }

        System.out.println(count);
        scr.close();

    }

    public static void main(String[] args) {
        part1();
        part2();
    }

}