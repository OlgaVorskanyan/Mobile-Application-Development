/* Olga Vorskanyan, Section B
Homework 03, Problem 2
*/

import java.util.Scanner;

public class Problem_2 {
    public static void main (String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the number you want us to check");
        String numberToCheck = a.nextLine();
        int preLastDigit = numberToCheck.charAt(numberToCheck.length()-2) - 48; //-48 because 0 is 48 in char
        int lastDigit = numberToCheck.charAt(numberToCheck.length()-1) - 48; //so every number is greater by 48
        int lastTwoDigits = preLastDigit * 10 + lastDigit;  //here I composed the number by b and c
        boolean checkDivisibility = (lastTwoDigits % 4 == 0);

        System.out.println("The fact that number is divisible by 4 is " + checkDivisibility);

    }
}