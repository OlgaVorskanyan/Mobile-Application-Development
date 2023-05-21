/* Olga Vorskanyan, Section B
Homework 05, Problem 03
*/


import java.util.Scanner;

public class Ex3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int k;
        int m;
        int l;
        int sum = 0;

        System.out.println("Enter the number of rows of matrix1");
        n = sc.nextInt();

        System.out.println("Enter the number columns of matrix1");
        m = sc.nextInt();

        int [][] mat1 = new int[n][m];

        System.out.println("Enter the elements of matrix1");

        for ( int i= 0 ; i < n ; i++ ) {
            for ( int j= 0 ; j < m; j++ )
                mat1[i][j] = sc.nextInt();
        }

        System.out.println("Enter the number of rows of matrix2");
        k = sc.nextInt();

        System.out.println("Enter the number of columns of matrix2");
        l = sc.nextInt();

        int [][] mat2 = new int[k][l];

        System.out.println("Enter the elements of matrix2");

        for (int i= 0 ; i < k ; i++ ) {
            for ( int j = 0 ; j < l; j++ )
                mat2[i][j] = sc.nextInt();
        }

        int [][] mat3 = new int[n][l];

        if(m==k) {
            for (int i = 0 ; i < n ; i++ )
                for (int j = 0 ; j < l; j++) {
                    for (int r = 0; r < m; r++ ) {
                        sum += mat1[i][r] * mat2[r][j] ;
                    }
                    mat3[i][j]=sum;
                    sum = 0;
                }

          System.out.print(n+" ");
          System.out.println(l);

            for ( int i= 0 ; i < n; i++ ) {
                for (int j=0 ; j < l; j++ )
                    System.out.print(mat3[i][j]+" ");
                System.out.println();

            }
        }

        else
            System.out.println("Multiplication does not exist. Check if the columns of the first matrix equals the " +
                    "rows of the second matrix ");


        if(m == k) {
            mat3 = matProduct(mat1, mat2);
        } else {
            System.out.println("Multiplication does not exist. Check if the columns of the first matrix equals the " +
                    "rows of the second matrix ");
        }

    }



    public static int[][] matProduct(int[][] mat1, int[][] mat2){ // assume the input is checked
        int n = mat1.length;
        int m = mat1[0].length;
        int l = mat2[0].length;
        int[][] product = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int r = 0; r < m; r++) {
                    product[i][j] += mat1[i][r] * mat2[r][j];
                }
            }
        }
        return product;

    }

}


