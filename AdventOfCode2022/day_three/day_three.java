package day_three;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class day_three {
    // Each rucksack has two compartments
    // First half of a line is the first compartment, second half is the second
    // a-z : Priority 1 - 26
    // A-Z : Priority 27 - 52
    // Find the item type that appears in both compartments and sum the total priority

    private static HashMap<Character, Integer> priority = new HashMap<>();
    static String filePath = "day_three/data/input.txt";
    static File file = new File(filePath);
    static Scanner scr;
    static String st;

// Method to initiate all hashmaps
private static void initMaps(){
    // Lower case
    priority.put('a', 1);
    priority.put('b', 2);
    priority.put('c', 3);
    priority.put('d', 4);
    priority.put('e', 5);
    priority.put('f', 6);
    priority.put('g', 7);
    priority.put('h', 8);
    priority.put('i', 9);
    priority.put('j', 10);
    priority.put('k', 11);
    priority.put('l', 12);
    priority.put('m', 13);
    priority.put('n', 14);
    priority.put('o', 15);
    priority.put('p', 16);
    priority.put('q', 17);
    priority.put('r', 18);
    priority.put('s', 19);
    priority.put('t', 20);
    priority.put('u', 21);
    priority.put('v', 22);
    priority.put('w', 23);
    priority.put('x', 24);
    priority.put('y', 25);
    priority.put('z', 26);
    // Upper case
    priority.put('A', 27);
    priority.put('B', 28);
    priority.put('C', 29);
    priority.put('D', 30);
    priority.put('E', 31);
    priority.put('F', 32);
    priority.put('G', 33);
    priority.put('H', 34);
    priority.put('I', 35);
    priority.put('J', 36);
    priority.put('K', 37);
    priority.put('L', 38);
    priority.put('M', 39);
    priority.put('N', 40);
    priority.put('O', 41);
    priority.put('P', 42);
    priority.put('Q', 43);
    priority.put('R', 44);
    priority.put('S', 45);
    priority.put('T', 46);
    priority.put('U', 47);
    priority.put('V', 48);
    priority.put('W', 49);
    priority.put('X', 50);
    priority.put('Y', 51);
    priority.put('Z', 52);
}

// First part of the challenge
public static void part1(){
    try{
        scr = new Scanner(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    int totalPriority = 0;
    while (scr.hasNextLine())
    {
        st = scr.nextLine();
        // Outerloop iterates through the first half of the list of contents
        outerloop:
        for(int i = 0; i < (st.length()/2); i++){
            // Innterloop iterates throught the second half of the list of contents
            for(int j = st.length()/2; j < st.length(); j++){
                // If there is a character match between the two halves add that character's priority to the total
                if(st.charAt(i) == st.charAt(j)){
                    totalPriority += priority.get(st.charAt(i));
                    break outerloop;
                }
            }
        }
    }
    System.out.println(totalPriority);
    scr.close();
}

// Second part of the challenge
public static void part2(){
    try{
        scr = new Scanner(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    int totalPriority = 0;
    ArrayList<char[]> groupRucksack = new ArrayList<char[]>();
    while (scr.hasNextLine())
    {
        st = scr.nextLine();
        // If the ArrayList does not have three lines yet add to the array
        if(groupRucksack.size() < 3) groupRucksack.add(st.toCharArray());
        // If the ArrayList contains three lines
        if (groupRucksack.size() == 3){
            // X iterates through the length of the first line
            // Y iterates through the length of the second line
            // Z iterates through the length of the third line
            outerloop:
            for(int x = 0; x < groupRucksack.get(0).length; x++){
                for(int y = 0; y < groupRucksack.get(1).length; y++){
                    for(int z = 0; z < groupRucksack.get(2).length; z++){
                        // If there is a corresponding match in all three lines then add the character's priority to the total, clear the array and break the loop
                        if(groupRucksack.get(0)[x] == groupRucksack.get(1)[y] && groupRucksack.get(0)[x] == groupRucksack.get(2)[z]){
                            totalPriority += priority.get(groupRucksack.get(0)[x]);
                            groupRucksack.remove(2);
                            groupRucksack.remove(1);
                            groupRucksack.remove(0);
                            break outerloop;       
                        }
                    }
                } 
            }
        }
    }   
     
    System.out.println(totalPriority);
    scr.close();
                
    }

public static void main(String[] args) {
    initMaps();
    part1();
    part2();
}

}