/* Olga Vorskanyan, Section B
Homework 03, Problem 4
*/

import java.util.Scanner;

public class Problem_4 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Type Windows based relative paths you want me to modify");
        String pathToModify = a.nextLine();
        String anotherPathToModify =  a.nextLine();
        String theOtherPathToModify = a.nextLine();
        System.out.println("Here are the modified paths");
        System.out.println(pathToModify.replace('\\', '/'));
        System.out.println(anotherPathToModify.replace('\\', '/'));
        System.out.println(theOtherPathToModify.replace('\\', '/'));


    }
}
