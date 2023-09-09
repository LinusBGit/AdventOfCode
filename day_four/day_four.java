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

    public static void part1() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;

        while (scr.hasNextLine()) {
            st = scr.nextLine();
            st = st.replace(",", "-");
            String[] parts = st.split("\\-");
            fElfStart = Integer.parseInt(parts[0]);
            fElfEnd = Integer.parseInt(parts[1]);
            sElfStart = Integer.parseInt(parts[2]);
            sElfEnd = Integer.parseInt(parts[3]);

            if ((fElfStart <= sElfStart && fElfEnd >= sElfEnd) || (sElfStart <= fElfStart && sElfEnd >= fElfEnd)) {
                count++;
            }
        }
        System.out.println(count);
        scr.close();
    }

    public static void part2() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;

        while (scr.hasNextLine()) {
            st = scr.nextLine();
            st = st.replace(",", "-");
            String[] parts = st.split("\\-");
            fElfStart = Integer.parseInt(parts[0]);
            fElfEnd = Integer.parseInt(parts[1]);
            sElfStart = Integer.parseInt(parts[2]);
            sElfEnd = Integer.parseInt(parts[3]);

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