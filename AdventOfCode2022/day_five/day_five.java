package day_five;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class day_five {

    static String filePath = "day_five/data/input.txt";
    static File file = new File(filePath);
    static Scanner scr;
    static String st;
    private static HashMap<Character, Stack<Character>> map = new HashMap<>();
    private static Stack<Character> stackOne = new Stack<Character>();
    private static Stack<Character> stackTwo = new Stack<Character>();
    private static Stack<Character> stackThree = new Stack<Character>();
    private static Stack<Character> stackFour = new Stack<Character>();
    private static Stack<Character> stackFive = new Stack<Character>();
    private static Stack<Character> stackSix = new Stack<Character>();
    private static Stack<Character> stackSeven = new Stack<Character>();
    private static Stack<Character> stackEight = new Stack<Character>();
    private static Stack<Character> stackNine = new Stack<Character>();

    // Method to initiate all hashmaps
    private static void initMaps() {
        map.put('1', stackOne);
        map.put('2', stackTwo);
        map.put('3', stackThree);
        map.put('4', stackFour);
        map.put('5', stackFive);
        map.put('6', stackSix);
        map.put('7', stackSeven);
        map.put('8', stackEight);
        map.put('9', stackNine);
    }

    // Method to initiate all stacks
    private static void initStacks() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        while (scr.hasNextLine()) {
            st = scr.nextLine();
            // Only run below if-statement for the first couple of line iterations 
            if (count < 8) {
                // If there is a character then push it into the stack
                if (st.charAt(1) != ' ')
                    stackOne.push(st.charAt(1));
                if (st.charAt(5) != ' ')
                    stackTwo.push(st.charAt(5));
                if (st.charAt(9) != ' ')
                    stackThree.push(st.charAt(9));
                if (st.charAt(13) != ' ')
                    stackFour.push(st.charAt(13));
                if (st.charAt(17) != ' ')
                    stackFive.push(st.charAt(17));
                if (st.charAt(21) != ' ')
                    stackSix.push(st.charAt(21));
                if (st.charAt(25) != ' ')
                    stackSeven.push(st.charAt(25));
                if (st.charAt(29) != ' ')
                    stackEight.push(st.charAt(29));
                if (st.charAt(33) != ' ')
                    stackNine.push(st.charAt(33));
                count++;
            } else
                break;
        }

        // Reverse all the stacks
        reverse(stackOne);
        reverse(stackTwo);
        reverse(stackThree);
        reverse(stackFour);
        reverse(stackFive);
        reverse(stackSix);
        reverse(stackSeven);
        reverse(stackEight);
        reverse(stackNine);
        scr.close();
    }

    // Method to reverse a stack
    public static void reverse(Stack<Character> st) {
        if (st.size() > 0) {

            // Hold all items in Function
            // Call Stack until we
            // reach end of the stack
            char x = st.peek();
            st.pop();
            reverse(st);

            // Insert all the items held
            // in Function Call Stack
            // one by one from the bottom
            // to top. Every item is
            // inserted at the bottom
            insert_at_bottom(x, st);
        }
    }

    static void insert_at_bottom(char x, Stack<Character> st) {

        if (st.isEmpty())
            st.push(x);

        else {

            // All items are held in Function
            // Call Stack until we reach end
            // of the stack. When the stack becomes
            // empty, the st.size() becomes 0, the
            // above if part is executed and
            // the item is inserted at the bottom
            char a = st.peek();
            st.pop();
            insert_at_bottom(x, st);

            // push allthe items held
            // in Function Call Stack
            // once the item is inserted
            // at the bottom
            st.push(a);
        }
    }

    // First part of the challenge
    public static void part1() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int amountToMove;
        Character moveFrom;
        Character moveTo;
        int count = 0;
        while (scr.hasNextLine()) {
            String test = scr.nextLine();
            // Only run below if-statement after 11 line iterations 
            if (count >= 10) {
                st = test;
                // If index 6 is not empty then it is a double digit integer
                if (st.charAt(6) != ' ') {
                    String temp = String.valueOf(Character.getNumericValue(st.charAt(5))) +
                            String.valueOf(Character.getNumericValue(st.charAt(6)));
                    amountToMove = Integer.parseInt(temp);
                    moveFrom = st.charAt(13);
                    moveTo = st.charAt(18);
                } 
                // If index 6 is empty then it is a single digit integer
                else {
                    amountToMove = Character.getNumericValue(st.charAt(5));
                    moveFrom = st.charAt(12);
                    moveTo = st.charAt(17);
                }

                // Pop the stack that is to be moved from and push into the stack that is to be moved to
                // Loop through this for as many times as amountToMove equals to
                for (int i = 0; i < amountToMove; i++) {
                    map.get(moveTo).push(map.get(moveFrom).pop());
                }
            } else
                count++;
        }

        String finalVal = "Final answer is: " +
                (String.valueOf(stackOne.lastElement()) +
                        String.valueOf(stackTwo.lastElement()) +
                        String.valueOf(stackThree.lastElement()) +
                        String.valueOf(stackFour.lastElement()) +
                        String.valueOf(stackFive.lastElement()) +
                        String.valueOf(stackSix.lastElement()) +
                        String.valueOf(stackSeven.lastElement()) +
                        String.valueOf(stackEight.lastElement()) +
                        String.valueOf(stackNine.lastElement()));
        System.out.println(finalVal);

        scr.close();
    }

    // Method to clear all stacks
    public static void emptyStacks() {
        stackOne.clear();
        stackTwo.clear();
        stackThree.clear();
        stackFour.clear();
        stackFive.clear();
        stackSix.clear();
        stackSeven.clear();
        stackEight.clear();
        stackNine.clear();
    }

    // Second part of the challenge
    public static void part2() {
        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int amountToMove;
        Character moveFrom;
        Character moveTo;
        int count = 0;
        Stack<Character> tempStack = new Stack<Character>();
        while (scr.hasNextLine()) {
            String test = scr.nextLine();
            if (count >= 10) {
                st = test;
                // If index 6 is not empty then it is a double digit integer
                if (st.charAt(6) != ' ') {
                    String temp = String.valueOf(Character.getNumericValue(st.charAt(5))) +
                            String.valueOf(Character.getNumericValue(st.charAt(6)));
                    amountToMove = Integer.parseInt(temp);
                    moveFrom = st.charAt(13);
                    moveTo = st.charAt(18);
                } 
                // If index 6 is empty then it is a single digit integer
                else {
                    amountToMove = Character.getNumericValue(st.charAt(5));
                    moveFrom = st.charAt(12);
                    moveTo = st.charAt(17);
                }

                // If moving multiple crates
                if (amountToMove > 1) {
                    // Using a temporary stack to store the values
                    for (int i = 0; i < amountToMove; i++)
                        tempStack.push(map.get(moveFrom).pop());

                    // Pop the temporary stack and push into the correct receiving stack
                    for (int j = 0; j < amountToMove; j++)
                        map.get(moveTo).push(tempStack.pop());

                } 
                // If moving a singular crate
                else
                    map.get(moveTo).push(map.get(moveFrom).pop());

            } else
                count++;
        }

        // Print out the final answer which is the element on top of each of the stacks 
        String finalVal = "Final answer is: " +
                (String.valueOf(stackOne.lastElement()) +
                        String.valueOf(stackTwo.lastElement()) +
                        String.valueOf(stackThree.lastElement()) +
                        String.valueOf(stackFour.lastElement()) +
                        String.valueOf(stackFive.lastElement()) +
                        String.valueOf(stackSix.lastElement()) +
                        String.valueOf(stackSeven.lastElement()) +
                        String.valueOf(stackEight.lastElement()) +
                        String.valueOf(stackNine.lastElement()));
        System.out.println(finalVal);

        scr.close();

    }

    public static void main(String[] args) {
        initMaps();
        initStacks();
        part1();
        emptyStacks();
        initStacks();
        part2();
        emptyStacks();
    }

}