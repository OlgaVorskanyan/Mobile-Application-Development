/* Olga Vorskanyan, Section B
Homework 04, Problem 3
*/

import java.util.Scanner;

public class Exercise_3 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Tell me the size of hexagon");
        int n = a.nextInt();
        for(int i = 1; i <= n + 1 ; i++) {
            if(i == 1) {
                for(int j = 1; j <= n; j++) System.out.print(" ");
                for(int j = 1; j <= n; j++) System.out.print("--");
                System.out.println();
            }
            else {
                for(int j = 1; j <= n - i + 1; j++) System.out.print(" ");
                System.out.print("/");
                for(int j = 1; j <= 2 * n + 2 * (i - 2) ; j++) System.out.print(" ");
                System.out.print("\\");
                System.out.println();
            }
        }
        for(int i = n; i >= 1; i--) {
            if(i == 1) {
                for(int j = 1; j <= n - 1; j++) System.out.print(" ");
                System.out.print("\\");
                for(int j = 1; j <= n; j++) System.out.print("__");
                System.out.print("/");
                System.out.println();
            } else {
                for(int j = 1; j <= n - i; j++) System.out.print(" ");
                System.out.print("\\");
                for(int j = 1; j <= 2 * n + 2 * (i - 1) ; j++) System.out.print(" ");
                System.out.print("/");
                System.out.println();
            }
        }
    }

}
