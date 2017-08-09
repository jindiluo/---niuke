package �������;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(findIndex(input));
        }

        scanner.close();
    }

    private static int findIndex(int n) {
        if (n <= 2) {
            return -1;
        }
        int[][] arr = {new int[2 * n - 1], new int[2 * n - 1], new int[2 * n - 1]};

        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;

        for (int i = 2; i < n; i++) {
            int curr = i % 3;
            int prev = (i - 1) % 3;

            int last = 2 * i; // ���һ���±�

            arr[curr][0] = 1; // ���õ�һ��ֵ
            arr[curr][1] = i; // ���õڶ���ֵ
            arr[curr][last] = 1; // ���õ�����һ��ֵ
            arr[curr][last - 1] = i; // ���õ����ڶ���ֵ

            for (int j = 2; j <= last - 2; j++) {
                arr[curr][j] = arr[prev][j - 2] + arr[prev][j - 1] + arr[prev][j];
            }
        }

        int curr = (n - 1) % 3;

        for (int i = 0; i < arr[curr].length; i++) {
            if (arr[curr][i] % 2 == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
