/**
 *
 */
/**
 * @author Administrator
 *
 */
package ÍÃ×Ó²Ø¶´;
import java.util.Scanner;

public class Main {

    public static void find(int[] circle, int x, int n) {
        int step = 0;
        int current = x;
        while (n-- > 0) {
            int index = (current + step) % circle.length;
            circle[index] = 1;
            step += 1;
            current = (index + 1) % circle.length;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int n = scanner.nextInt();
            int[] circle = new int[20];
            find(circle, x - 1, n);
            boolean can = false;
            for (int i = 0; i < circle.length; ++i) {
                if (circle[i] != 1) {
                    System.out.print(i + 1);
                    System.out.print(" ");
                    can = true;
                }
            }
            if (can) {
                System.out.println();
            } else {
                System.out.println("-1");
            }
        }
        scanner.close();
    }

}