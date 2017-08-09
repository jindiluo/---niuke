package ���ʷ�ת;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
//            System.out.println("|" + reverse(input) + "|");
            System.out.println(reverse(input));
        }

        scanner.close();
    }

    private static String reverse(String s) {
        char[] chars = new char[s.length()];
        int pos = 0;

        // ��������ַ�����ѹ����ȥ��ǰ��������Ŀո��м䵥�ʼ�ֻ����һ���ո�
        for (int i = 0; i < s.length();) {
            // �ӿ�ʼ��iλ�ÿ�ʼ�ҵ�һ���ǿհ��ַ�
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            // �ӿ�ʼ��iλ�ÿ�ʼ�ҵ�һ���հ��ַ�
            while (i < s.length() && s.charAt(i) != ' ') {
                chars[pos] = s.charAt(i);
                pos++;
                i++;
            }

            // ��ʱiλ����һ���հ��ַ���˵��i���滹�����зǿհ��ַ�
            // ������Ҫ���һ���հ��ַ���Ϊ�ָ�
            if (i< s.length()) {
                chars[pos] = ' ';
                pos++;
            }
        }
        // ���ѹ�������һ���ַ���λ��
        pos--;


//        System.out.println("|" + new String(chars, 0, pos+1) + "|");

        // ���������ַ�����תһ��
        reverse(chars, 0, pos);

        // ������ÿ�����ʽ��з�ת
        for(int i = 0, j; i <= pos; i++) {
            j = i;
            // ��i�ӿ�ʼ�ĵ�һ���հ��ַ�
            while (i <= pos && chars[i] != ' ') {
                i++;
            }

            // ���е��ʷ�ת
            reverse(chars, j, i - 1);
        }

        return new String(chars, 0, pos + 1);
    }

    private static void reverse(char[] arr, int beg, int end) {
        char tmp;
        while (beg < end) {
            tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;
            beg++;
            end--;
        }
    }


}

