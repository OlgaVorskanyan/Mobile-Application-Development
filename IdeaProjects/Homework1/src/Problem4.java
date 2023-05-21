/* Olga Vorskanyan
OOP, Section B, HW01, Problem 4
*/

public class Problem4 {
    public static void main (String[] args) {
        int day = 1;
        int month = 12;
        int year = 2000;
        int date = day*1000000 + month*10000 + year;
        System.out.println("The date of my birth is " + date);
    }
}
