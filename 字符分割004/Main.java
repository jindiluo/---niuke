package �ַ��ָ�004;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder(256);
        while (scanner.hasNext()) {
            builder.setLength(0);
            String input = scanner.nextLine();
            stringSplit(builder, input);
            input = scanner.nextLine();
            stringSplit(builder, input);
            System.out.print(builder);
        }

        scanner.close();
    }

    private static void stringSplit(StringBuilder builder, String str) {
        if (str == null || str.length() < 1) {
            return;
        }

        int pos = 0;
        while ((pos += 8) < str.length()) {
            builder.append(str.substring(pos - 8, pos)).append("\n");

        }

        // ���str.length() < pos��˵�����Ĳ���8���ַ����߸պ�8��
        if (str.length() <= pos) {
            builder.append(str.substring(pos - 8, str.length()));

            for (int i = str.length(); i < pos; i++) {
                builder.append(0);
            }
            builder.append("\n");
        }
    }
}
