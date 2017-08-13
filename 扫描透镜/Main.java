/**
 *
 */
/**
 * @author Administrator
 *
 */
package ɨ��͸��;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int LENGTH = 2;

    public static void main(String[] args) throws FileNotFoundException {

        int N = 0, M = 0, K;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            // 1.��������
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();
            int[][] num = new int[N][M];// Ģ���ֲ�
            while (K > 0) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                if (x < N && y < M) {
                    num[x][y]++;
                    K--;
                }
            }
            // 2.ͳ�Ƹ���
            Point firstPoint = findMaxNum(N, M, num);
            clear(firstPoint, num, N, M);
            Point secondPoint = findMaxNum(N, M, num);
            System.out.println(firstPoint.count + secondPoint.count);
        }

    }

    // x,y
    public static Point getNumInLocation(int N, int M, int[][] num, int startX, int startY) {
        int endX, endY;
        // 1.ȷ������
        if (startX + LENGTH > N - 1) {
            endX = N - 1;
        } else {
            endX = startX + LENGTH;
        }

        if (startY + LENGTH > M - 1) {
            endY = M - 1;
        } else {
            endY = startY + LENGTH;
        }
        // 2.ͳ�Ƹ���
        Point point = new Main().new Point();
        point.count = 0;
        point.x = startX;
        point.y = startY;
        point.endX = endX;
        point.endY = endY;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (num[i][j] > 0) {
                    point.count++;
                }
            }
        }
        return point;
    }

    // ͳ����ɨ�赽�����ֵ
    private static Point findMaxNum(int N, int M, int[][] num) {
        Point point = new Main().new Point();
        point.count = 0;
        point.x = 0;
        point.y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Point tempPoint = getNumInLocation(N, M, num, i, j);
                if (point.count < tempPoint.count) {
                    point = tempPoint;
                }
            }
        }
        return point;
    }

    // ��һ��ɨ���� �����������
    private static void clear(Point point, int[][] num, int N, int M) {
        for (int i = point.x; i <= point.endX; i++) {
            for (int j = point.y; j <= point.endY; j++) {
                if (num[i][j] > 0 && i < N & j < M) {
                    num[i][j]--;
                }
            }
        }
    }

    class Point {
        int x;// ��ʼ����
        int y;// ��ʼ����
        int count;// ����������
        int endX;// ��������
        int endY;// ��������
    }
}