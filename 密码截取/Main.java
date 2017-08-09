package �����ȡ;

import java.util.Scanner;

/**
 * Author: ������
 * Date: 2015-12-24 10:57
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String reverse = new StringBuilder(input).reverse().toString();
            System.out.println(findMaxSubstring(input, reverse));
        }

        scanner.close();
    }

    /**
     * Substring���ⲻ��Ҫ���±������ǵ����ģ���Ҫ��ÿ��
     * ����������Ϊ1�� �������±�����Ϊ��
     * < i, i+1, i+2, ..., i+k-1 > �� < j, j+1, j+2, ..., j+k-1 >
     * ���Subquence����Ķ�̬�滮�ⷨ��SubstringҲ�����ö�̬�滮�������
     * c[i][j]��ʾ������Xi�ַ����͡�Yi�ַ��������Substring�ĳ��ȣ�����
     * X = < y, e, d, f >
     * Y = < y, e, k, f >
     * c[1][1] = 1
     * c[2][2] = 2
     * c[3][3] = 0
     * c[4][4] = 1
     * ��̬ת�Ʒ���Ϊ��
     * ���xi == yj�� �� c[i][j] = c[i-1][j-1]+1
     * ���xi != yj,  ��ôc[i][j] = 0
     * �����Longest Common Substring�ĳ��ȵ���
     * max{c[i][j],  1 <= i <= n�� 1 <= j<= m}
     *
     * @param a
     * @param b
     * @return
     */
    private static int findMaxSubstring(String a, String b) {

        int aLen = a.length() + 1;
        int bLen = b.length() + 1;
        int max = 0;
        int x = 0;

        // ��ʼֵ��Ϊ0
        int[][] c = new int[aLen][bLen];

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = 0;
                }

                if (c[i][j] > max) {
                    max = c[i][j];
                }
            }
        }

        return max;
    }
}
