package �������һ��ż����ӽ�����������;



import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(findPrimeNumber(n));

        }


        scanner.close();
    }

    private static String findPrimeNumber(int n) {

        int[] a = new int[4];

        int i = n - 1;
        int idx = 0;
        // ��С�ڵ�n�������������п���ֻ�ҵ�һ��
        while (i >= 2 && idx < 2) {
            if (isPrime(i)) {
                // ��֤С����ǰ������ں�
                a[1 - idx] = i;
                idx++;
            }

            i--;
        }


        i = n + 1;

        // ˵����n֮ǰ��������ӽ�n���������ǾͿ�ֻҪ��[n+1, n]֮�����������������п���û������
        if (idx == 2) {

            while (i <= 2 * n && idx < 4) {
                if (isPrime(i)) {
                    a[idx] = i;
                    idx++;
                }

                i++;
            }

            // [n+1, n]������
            if (idx == 2) {
                return a[0] + " " + a[1];
            }
            // [n+1, n]ֻ��һ������
            else if (idx == 3) {
                // a[2]��n�ľ����ǰ����Զ
                if (n - a[0] <= a[2] - n) {
                    return a[0] + " " + a[1];
                } else {
                    return a[1] + " " + a[2];
                }
            }
            // [n+1, n]����������
            else {
                // ȡ�������
                if (n - a[0] <= a[2] - n) {
                    return a[0] + " " + a[1];
                }
                // ȡ�ұ�����
                else if (n - a[1] >= a[3] - n) {
                    return a[2] + " " + a[3];
                }
                // ȡ�м�����
                else {
                    return a[1] + " " + a[2];
                }
            }
        }
        // ��[2, n-1]֮��ֻ��һ����������û��
        else {
            while (i <= Integer.MAX_VALUE && idx < 2) {
                if (isPrime(i)) {
                    a[idx] = i;
                    idx++;
                }

                i++;
            }

            return a[0] + " " + a[1];
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
