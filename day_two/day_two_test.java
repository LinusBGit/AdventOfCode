package day_two;
import java.io.File;
import java.io.FileNotFoundException; import java.util.ArrayList; import java.util.HashMap; import java.util.Scanner;
public class day_two_test {
// Loss = 0;
// Draw = 3;
// Win = 6;

// Rock = 1
// Paper = 2
// Scissors = 3
private static HashMap<String, Integer> results = new HashMap<>();
private static HashMap<String, String> strategy = new HashMap<>();


private static void initMaps(){
    // A = rock
    // B = paper
    // C = scissors

    // X = rock
    // Y = paper
    // Z = scissors

    // for when they pick rock
    results.put("A X", 4);
    results.put("A Y", 8);
    results.put("A Z", 3);

    // for when they pick paper
    results.put("B X", 1);
    results.put("B Y", 5);
    results.put("B Z", 9);

    // for when they pick scissors
    results.put("C X", 7);
    results.put("C Y", 2);
    results.put("C Z", 6);

    // for when they pick Rock
    strategy.put("A X", "A Z");
    strategy.put("A Y", "A X");
    strategy.put("A Z", "A Y");

    // for when they pick paper
    strategy.put("B X", "B X");
    strategy.put("B Y", "B Y");
    strategy.put("B Z", "B Z");

    // for when they pick scissors
    strategy.put("C X", "C Y");
    strategy.put("C Y", "C Z");
    strategy.put("C Z", "C X");
}

private static void part1(){
    String path = "day_two/data/input.txt";
    File file = new File(path);

    Scanner scr;

    try {
        scr = new Scanner(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    int totalScore = 0;

    while(scr.hasNextLine()){

        String s = scr.nextLine();
        totalScore += results.get(s);

    }

    System.out.println(totalScore);
}

private static void part2(){
    String path = "day_two/data/input.txt";
    File file = new File(path);

    Scanner scr;

    try {
        scr = new Scanner(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    int totalScore = 0;

    while(scr.hasNextLine()){

        String s = scr.nextLine();
        s = strategy.get(s);
        totalScore += results.get(s);

    }

    System.out.println(totalScore);
}

public static void main(String[] args) {


    initMaps();
    part1();
    part2();


}
}