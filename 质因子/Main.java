package ������;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            long input = scanner.nextLong();
            System.out.println(findPrimes(input));
        }
        scanner.close();
    }


    private static String findPrimes(long num) {

        StringBuilder builder = new StringBuilder(128);
        long i = 2;
        while (i <= num) {
            // ÿ�ε�iһ��������ʱ�Ż�����
            // ��Ϊ�����һ��������������һ�����ɸ�С��������˵����ģ�
            // ����iǰ�������Ѿ�ȫ����ʹ�ù��ˣ�����������num��
            while (num % i == 0) {
                builder.append(i).append(' ');
                num /= i;
            }
            i++;
        }

       return builder.toString();
    }

}

