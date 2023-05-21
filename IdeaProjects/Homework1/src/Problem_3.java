/* Olga Vorskanyan, Section B
Homework 03, Problem 3
*/


import java.util.Scanner;

public class Problem_3 {
    public static void main (String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the line you want us to swap");
        String lineToSwap = a.nextLine();
        String firstHalf = lineToSwap.substring(0, (lineToSwap.length()/2)); //substring doesn't include the last index mentioned
        String secondHalf = lineToSwap.substring((lineToSwap.length()/2), lineToSwap.length());
        String newString = secondHalf + firstHalf; // Here I concatenated my two strings
        System.out.println("The swapped string");
        System.out.println(newString);

    }

}
