package ͳ��ÿ���µ���������;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(countRabbit(input));
        }

        scanner.close();
    }

    /**
     * ͳ�Ƶ�n���µ���������
     * ���ӿ��Կ�����һ����δ���죬�ڶ����³��죬�������²��У����Թ���һ����쳲��������С�����
     *
     * @param input
     * @return
     */
    private static int countRabbit(int input) {

        if (input <= 0) {
            return 0;
        } else if (input <= 2) {
            return 1;
        } else {

            int prev1 = 1;
            int prev2 = 1;
            int result = 0;
            for (int i = 3; i <= input; i++) {
                result = prev1 + prev2;
                prev1 = prev2;
                prev2 = result;
            }
            return result;
        }
    }
}

