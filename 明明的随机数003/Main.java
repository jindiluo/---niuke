package �����������003;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // ��ȡ�����������
            int num = scanner.nextInt();
            // ������������
            Set<Integer> set = new TreeSet<>();
            while ((--num) >= 0) {
                set.add(scanner.nextInt());
            }

            System.out.print(setToString(set));
        }
    }

    private static String setToString(Set<Integer> set) {
        StringBuilder builder = new StringBuilder(128);
        for (Integer i : set) {
            builder.append(i).append("\n");
        }

        return builder.toString();
    }
}

