/* Olga Vorskanyan, Section B
Homework 05, Problem 02
*/

//1st version

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [] arr = new double[52];
        double total = 0;
        double maxDiff = 0;
        double minDiff;

        System.out.println("Input the numbers!");

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextDouble();



        for (int i = 0; i < arr.length; i++)
            total = total + arr[i];

        minDiff = total;


        double average = total / arr.length;


        for (int i = 0; i < arr.length - 2; i++) {
                double diffOfNums = arr[i+1] - arr[i];
                if (diffOfNums > maxDiff) {
                    maxDiff = diffOfNums;
                }
            }


        for (int i = 0; i < arr.length-2; i++) {
            double diffOfNums = arr[i+1] - arr[i];
            if (diffOfNums >= 0 && diffOfNums < minDiff) {
                minDiff = diffOfNums;
            }
           }


        System.out.println("The average is " + average + "," + "the sharpest increase is " + maxDiff + "," + "the minimum increase is " + minDiff);





        double total1 = 0;
        double previousValue = 0; // price can't be 0 or less
        double minimumIncrease = total1;
        double sharpestIncrease = 0;

        for(int i = 0; i < 52;i++) {
            double currentValue = sc.nextDouble();
            total1 += currentValue;
            if(previousValue == 0) {
                previousValue = currentValue;
            } else {
                double diffOfNums = currentValue - previousValue;
                if (diffOfNums >= 0 && diffOfNums < minDiff) {
                    minDiff = diffOfNums;
                }
                if (diffOfNums > maxDiff) {
                    maxDiff = diffOfNums;
                }
                previousValue = currentValue;
            }

        }

        double avg = total/52;

        System.out.println("The average is " + avg);
        System.out.println("The minimum increase is " + minimumIncrease);
        System.out.println("The sharpest increase is " + sharpestIncrease);
        }

    }



