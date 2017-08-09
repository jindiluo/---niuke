package ����У��;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(passwordValidate(input));
        }
        scanner.close();

    }

    private static String passwordValidate(String input) {
        final String OK = "OK";
        final String NG = "NG";

        // ���ȳ���8
        if (input == null || input.length() < 9) {
            return NG;
        }

        int[] kind = new int[4];

        // ͳ��
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                kind[0] |= 1;
            } else if (ch >= 'a' && ch <= 'z') {
                kind[1] |= 1;
            } else if (ch >= '0' && ch <= '9') {
                kind[2] |= 1;
            } else {
                kind[3] |= 1;
            }
        }

        // С������
        if ((kind[0] + kind[1] + kind[2] + kind[3]) < 3) {
            return NG;
        }

        for (int i = 0; i < input.length() - 3; i++) {
            String s1 = input.substring(i, i + 3);
            String s2 = input.substring(i + 3, input.length());
            if (s2.contains(s1)) {
                return NG;
            }
        }
        return OK;
    }
}
