/* Olga Vorskanyan, Section B
Homework 04, Problem 2
*/


import java.util.Scanner;

public class Exercise_2 {
    public static void main (String[] args) {
        int randomNumber = (int)(Math.random() * 100) + 1;
        Scanner a = new Scanner(System.in);
        boolean isCorrect = false;
        while(!isCorrect) {
            System.out.println("I have generated a random number between 1 and 100. Please make a guess.");
            int numberToCheck = a.nextInt();
            if(randomNumber<numberToCheck)
                System.out.println("My number is smaller than " + numberToCheck + "Please make a guess.");
            else if (randomNumber > numberToCheck)
                System.out.println("My number is larger than " + numberToCheck + "Please make a guess.");
            else {
                System.out.println("You guessed it! Well done and thank you for playing.");
                isCorrect = true;
            }
        }


        for (int n = 1; n <= 2; n++) {
            System.out.println("I have generated a random number between 1 and 100. Please make a guess.");
            int numberToCheck = a.nextInt();
            if(randomNumber<numberToCheck) {
                System.out.println("My number is smaller than " + numberToCheck + "Please make a guess.");
                n--;
            }
            else if (randomNumber > numberToCheck) {
                System.out.println("My number is larger than " + numberToCheck + "Please make a guess.");
                n--;
            } else {
                System.out.println("You guessed it! Well done and thank you for playing.");
                break;
            }

        }

      isCorrect = false;

        do {
            System.out.println("I have generated a random number between 1 and 100. Please make a guess.");
            int numberToCheck = a.nextInt();
            if(randomNumber<numberToCheck)
                System.out.println("My number is smaller than " + numberToCheck + "Please make a guess.");
            else if (randomNumber > numberToCheck)
                System.out.println("My number is larger than " + numberToCheck + "Please make a guess.");
            else {
                System.out.println("You guessed it! Well done and thank you for playing.");
                isCorrect = true;
            }
        } while (!isCorrect);
    }
}



