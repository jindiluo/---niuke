package dna����;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int n = scanner.nextInt();
            System.out.println(maxRatio(input, n));
        }

        scanner.close();
    }

    /**
     * ��ʼ���������飬һ��������ֵ����K[N]��һ�����к�����SUM[N]���ȱ���һ�����У�
     * ΪC����G��K[i]Ϊ1����������Ϊ0��Ȼ���������M��K[I]֮�ʹ���SUM���С�
     *
     * @param s
     * @param m
     * @return
     */
    private static String maxRatio(String s, int m) {
        int[] k = new int[s.length()];
        int[] sum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'C' || c == 'G') {
                k[i]++;
            }
        }

        for (int i = 0; i < k.length - m; i++) {
            for (int j = 0; j < m; j++) {
                sum[i] += k[i + j];
            }
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < k.length - 1; i++) {
            if (sum[i] > max) {
                max = sum[i];
                idx = i;
            }
        }

        return s.substring(idx, idx + m);
    }
}
