/**
 *
 */
/**
 * @author Administrator
 *
 */
package адлЛ;
import java.util.Scanner;

public class Main {

    public static boolean isProper(int[][] A, int[][] B, int d) {
        for (int i = 0; i < A.length; ++i) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            for (int j = 0; j < B.length; ++j) {
                int b1 = B[j][0];
                int b2 = B[j][1];
                if (b1 <= a2 && b2 >= a1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[][] A = new int[p][2];
            int[][] B = new int[q][2];
            for (int i = 0; i < p; ++i) {
                A[i][0] = scanner.nextInt();
                A[i][1] = scanner.nextInt();
            }
            for (int j = 0; j < q; ++j) {
                B[j][0] = scanner.nextInt();
                B[j][1] = scanner.nextInt();
            }

            int count = 0;
            for (int i = l; i <= r; ++i) {
                if (isProper(A, B, i)) {
                    ++count;
                }
            }
            System.out.println(count);
        }
    }
}