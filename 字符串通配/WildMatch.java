/**
 *
 */
/**
 * @author Administrator
 *
 */
package �ַ���ͨ��;


import java.util.Scanner;

public class WildMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String A = scanner.next();
            int m = scanner.nextInt();
            String B = scanner.next();
            System.out.println(chkWildMatch(A, n, B, m));
        }
    }

    public static boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // d[i][j]��ʾA�е�1~iλ����ƥ��B�е�1~jλ
        boolean[][] d = new boolean[lena + 1][lenb + 1];
        // ��ʼ��
        d[0][0] = true;
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (B.charAt(j - 1) == '*') {
                    d[i][j] = d[i - 1][j] || d[i][j - 1];
                } else if (B.charAt(j - 1) == '.') {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = d[i - 1][j - 1] && A.charAt(i - 1) == B.charAt(j - 1);
                }
            }
        }
        return d[lena][lenb];
    }
}