package 表示数字;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(markNumber(input));
        }

        scanner.close();
    }

    private static String markNumber(String s) {

//注意需要一个mark，标记它
        boolean marked = false;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!marked && c >= '0' && c <= '9') {
                builder.append('*');
                marked = true;
            } if (i > 0 && marked && (c< '0' || c > '9')) {
                builder.append('*');
                marked = false;
            }
            builder.append(c);
        }

        if (marked) {
            builder.append('*');
        }

        return builder.toString();
    }
}
