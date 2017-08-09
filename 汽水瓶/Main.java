package ��ˮƿ;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        int num;
        while (scanner.hasNextInt() && (num = scanner.nextInt()) != 0) {
            System.out.println(bottle(num));
        }
        scanner.close();
    }

    private static int bottle(int num) {
        final int BASE = 3;

        if (num < BASE - 1 ) {
            return 0;
        }

        int result = 0;


        while (num > BASE - 1) {
            // ���κȵ�������
            int drink = num / BASE;
            // �ܹ��ȵ�����
            result += drink;
            // ����Ŀǰ�е�ƿ��
            num = num % BASE + drink;
        }

        if (num == BASE - 1) {
            // �������bASE-1��ƿ�ӣ��ǾͿ��������ϰ��һƿ�������������ƿ��
            // �ֿ��Ի�һƿ���ֶ����һƿ
            result++;
        }

        return result;
    }
}

