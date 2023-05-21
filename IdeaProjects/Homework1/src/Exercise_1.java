/* Olga Vorskanyan, Section B
Homework 04, Problem 1
*/


import java.util.Scanner;

public class Exercise_1 {
    public static void main (String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the number you want us to check");
        int numberToCheck = a.nextInt();

        if(numberToCheck>=1 && numberToCheck<=4)
            System.out.println("From the Primary school");
        else if (numberToCheck<=9)
            System.out.println("From the Middle school");
        else if (numberToCheck<=12)
            System.out.println("From the High school");
        else
            System.out.println("Not a school year!");


        switch(numberToCheck)
        {
            case 1: case 2: case 3: case 4:
                System.out.println("From the Primary school");
                break;
            case 5: case 6: case 7: case 8: case 9:
                System.out.println("From the Middle school");
                break;
            case 10: case 11: case 12:
                System.out.println("From the High school");
                break;
            default:
                System.out.println("Not a school year!");
                break;
        }


    }
}


