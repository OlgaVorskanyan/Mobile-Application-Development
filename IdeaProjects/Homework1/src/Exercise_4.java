/* Olga Vorskanyan, Section B
Homework 04, Problem 4
*/


import java.util.Scanner;

public class Exercise_4 {
    public static void main (String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Tell me the number of the rooms");
        int numberOfRooms = a.nextInt();
        int sumOfAllRooms = ((numberOfRooms) * (1 + numberOfRooms))/2;
        System.out.println("Tell me the available rooms");
        int sumOfAvailableRooms = 0;
        for( int n = 1; n <= numberOfRooms - 1; n++ ) {
            sumOfAvailableRooms += a.nextInt();
        }

        int theAnswer = sumOfAllRooms - sumOfAvailableRooms;
        System.out.println(theAnswer);

    }
}
