package �ַ���������_�����ȡ;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(longestPalindrome(input));
        }

        scanner.close();
    }

    /**
     * ����Ȿ�������ַ����е��������ִ��ĳ���
     * ��̬�滮����
     * ����dp[ i ][ j ]��ֵΪtrue����ʾ�ַ���s���±�� i �� j ���ַ���ɵ��Ӵ��ǻ��Ĵ�����ô�����Ƴ���
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]��
     * ����һ��������������Ҫ����i+1, j -1�������п��� i + 1 = j -1, i +1 = (j - 1) -1��
     * �����Ҫ�����׼��������������ϵĹ�ʽ��
     * a. i + 1 = j -1�������ĳ���Ϊ1ʱ��dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1�������ĳ���Ϊ2ʱ��dp[ i ][ i + 1] = ��s[ i ] == s[ i + 1]����
     * �������Ϸ����Ϳ���д�������ˡ���Ҫע����Ƕ�̬�滮��Ҫ�����O(n^2)�Ŀռ䡣
     *
     * @param s �����ַ���
     * @return �������ִ��ĳ���
     */
    private static int longestPalindrome(String s) {

        // �����ǷǷ���������������null

        int maxLen = 0;
        int len = s.length();
        boolean[][] t = new boolean[len][len];

        // �����ַ������ǻ���
        for (int i = 0; i < len; i++) {
            t[i][i] = true;
            maxLen = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // �󳤶ȴ���2���Ӵ��Ƿ��ǻ��Ĵ�
        for (int gap = 3; gap <= len; gap++) {
            for (int i = 0, j; (j = i + gap - 1) <= len - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    t[i][j] = t[i+1][j-1];
                    if (t[i][j] && gap > maxLen) {
                        maxLen = gap;
                    }
                } else {
                    t[i][j] = false;
                }
            }
        }




        return maxLen;
    }
}

