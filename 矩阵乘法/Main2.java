package æÿ’Û≥À∑®;

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       // Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        while (scanner.hasNextInt()) {
           int x = scanner.nextInt();
           int  y = scanner.nextInt();
           int  z = scanner.nextInt();
          int[][]  a = new int[x][y];
         int[][]   b = new int[y][z];
            int[][] c = new int[x][z];
            for (int j = 0; j < x; j++) {
                for (int i = 0; i < y; i++) {
                    a[j][i] = scanner.nextInt();
                }
            }

            for (int j = 0; j < y; j++) {
                for (int i = 0; i < z; i++) {
                    b[j][i] = scanner.nextInt();
                }
            }

            matrixMultiple(a, b, c);
        }
        scanner.close();
    }

    private static void matrixMultiple(int[][] a, int[][] b, int[][] c) {
        int x = a.length, y = a[0].length, z = b[0].length;

        for (int k = 0; k < z; k++) {
            for (int j = 0; j < x; j++) {
//              int sum = 0;
                for (int i = 0; i < y; i++) {
                    c[j][k] += a[j][i] * b[i][k];
                }
//              c[j][k] = sum;
//              System.out.println(sum);
            }
        }
        printMatrix(c);
    }

    static void printMatrix(int[][] m) {
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m[0].length; i++) {
                if (i == m[0].length - 1)
                    System.out.print(m[j][i]);
                else
                    System.out.print(m[j][i] + " ");
            }
            System.out.println();
        }

    }
}

