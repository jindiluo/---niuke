package �ַ�����ת;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            System.out.println(stringReverse(input));
        }
        scanner.close();
    }

    private static String stringReverse(String input) {
        StringBuilder builder = new StringBuilder(input.length());

        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }

        return builder.toString();
    }
}

