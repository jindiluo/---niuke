package ��������;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input  = scanner.nextLine();
            System.out.println(reverseSentence(input));
        }

        scanner.close();
    }



    private static String reverseSentence(String str) {

        char[] chars = str.toCharArray();

        // ��ת��������
        reverse(chars, 0, chars.length - 1);

        for (int i = 0, j; i < chars.length;  i = j + 1) {
            // �Ҵ�iλ�ÿ�ʼ��ĵ�һ���ǿհ��ַ�
            while (i < chars.length && chars[i] ==' ' ) {
                i++;
            }

            j = i + 1;
            // ��iλ��֮��ĵ�һ���հ��ַ�
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
        }


        return new String(chars);
    }

    /**
     * �ַ����鷭ת
     * @param str
     * @param start
     * @param end
     */
    private static void reverse(char[] str, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start++;
            end--;
        }
    }
}

