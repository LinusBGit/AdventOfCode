package day_two;
import java.io.*;
import java.util.Scanner;

public class day_two {

        // A, X = ROCK
        // B, Y = PAPER
        // C, Z = SCISSORS
        // ROCK 1 POINT
        // PAPER 2 POINTS
        // SCISSCORS 3 POINTS
        // 0 POINTS LOSS
        // 3 POINTS DRAW
        // 6 POINTS WIN

    static int rock = 1;
    static int paper = 2;
    static int scissors = 3;
    static int win = 6;
    static int draw = 3;
    

    public static int checkVal(String st){
        // DRAW ROCK VS ROCK
           if(st.equals("A X")){
            return (3 + 1);
           }
           // LOSS ROCK VS SCISSORS
           if(st.equals("A Z")){
            return 3;
           }
           // WIN ROCK VS PAPER
           if(st.equals("A Y")){
            return (6 + 2);
           }


           // DRAW PAPER VS PAPER
           if(st.equals("B Y")){
            return (3 + 2);
           }
           // WIN PAPER VS SCISSORS
           if(st.equals("C Y")){
            return (6 + 3);
           }
           // LOSS PAPER VS ROCK
           if(st.equals("B X")){
            return 1;
           }


           // DRAW SCISSORS VS SCISSORS
           if(st.equals("C Z")){
            return (3 + 3);
           }
           // WIN SCISSORS VS ROCK
           if(st.equals("C X")){
            return (6 + 1);
           }
           // LOSS SCISSORS VS PAPER
           if(st.equals("C Y")){
            return 2;
           }
           
        return 0;
    }

    public static void main(String[] args) throws Exception
    {
        int sum = 0;
        String filePath = "day_two/data/input.txt";
        File file = new File(filePath);
        Scanner scr = new Scanner(file);
        while(scr.hasNextLine()){
            String st = scr.nextLine();
            sum += checkVal(st);
        }
        System.out.println(sum);  
            
    }
}