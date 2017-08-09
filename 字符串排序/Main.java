package �ַ�������;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            // �޳����봮�еķ�Ӣ����ĸ�ַ�
            // ͬʱ�������˳�����ĸ˳�򴮳�һ���ַ���
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == (i + 'a') || str.charAt(j) == (i + 'A')) {
                        builder.append(str.charAt(j));
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            int k = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!isLetter(str.charAt(i))) {
                    result.append(str.charAt(i));
                } else {
                    result.append(builder.charAt(k));
                    k++;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }

    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}

