package �ַ�����;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(reverse(input));
        }

        scanner.close();
    }

    private static String reverse(String s) {
        char[] c = new char[s.length()];

        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            c[j] = s.charAt(i);
        }
        return new String (c);
    }
}

