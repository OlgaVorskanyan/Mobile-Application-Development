/* Olga Vorskanyan, Section B
Homework 03, Problem 1
*/

import java.util.Scanner;

public class Problem_1 {
    public static void main (String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the number you want us to check");
        int numberToCheck = a.nextInt();
        boolean checkDivisibility = (numberToCheck % 4 == 0);

        System.out.println("The fact that number is divisible by 4 is " + checkDivisibility);

    }
}
