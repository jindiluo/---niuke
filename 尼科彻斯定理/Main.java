package ��Ƴ�˹����;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getSequeOddNum(n));
        }

        scanner.close();
    }

    /**
     * n����������֮��
     * ��˵����
     * ���n�����������n^2-(n-1),n^2-(n-3)...n^2-(2),n^2-(0),n^2+(2)...n^2+(n-3),n^2+(n-1) һ����n��������Ϊn^3
     * ���n��ż�������n^2-(n-1),n^2-(n-3)...n^2-(1),n^2+(1)...n^2+(n-3),n^2+(n-1) һ����n��������Ϊn^3
     *
     * @param n
     * @return
     */
    private static String getSequeOddNum(int n) {

        int lo = n * n - (n - 1);
        int hi = n * n + (n - 1);

        StringBuilder builder = new StringBuilder();
        for (int i = lo; i <= hi; i += 2) {
            builder.append(i).append('+');
        }

        return builder.substring(0, builder.length() - 1);
    }
}
