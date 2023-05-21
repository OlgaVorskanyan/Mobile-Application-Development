/* Olga Vorskanyan, Section B
Homework 05, Problem 01
*/


import java.util.Scanner;


public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the exact amount of money");
        int sumOfPrices = sc.nextInt();

        String[] namesOfCandies = new String[1000];

        int[] pricesOfCandies = new int[1000];

        int c = 0;

        while(sc.hasNext() || sc.hasNextInt())  { //filling the arrays
            namesOfCandies[c] = sc.next();
            pricesOfCandies[c++] = sc.nextInt();
        }

        for(int i = 0; i < c; i++) {
            for(int j = i+1; j < c; j++)  {
                double maxOfFirstCandy = (double)sumOfPrices / pricesOfCandies[i];
                int x;
                if(maxOfFirstCandy - (int)maxOfFirstCandy == 0) {
                    x = (int)(maxOfFirstCandy-1);
                } else {
                    x = (int)(maxOfFirstCandy);
                }
                for(int z = 1; z <= x; z++) {
                    double y = (double) (sumOfPrices - pricesOfCandies[i] * z)/pricesOfCandies[j];
                    if(y-(int)y == 0) {
                        System.out.println(namesOfCandies[i] + " and " + namesOfCandies[j]);
                        break;
                    }
                }
            }
        }





    }
}
