package ���������;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            double d = scanner.nextDouble();
            System.out.printf("%.1f", getCubeRoot(d));
        }

        scanner.close();
    }

    /**
     * ʹ��ţ�ٵ�������������
     * ��֪����ţ�ٵ������󷽳�F��x��=0�Ľ�Ĺ�ʽΪX[n+1] = X[n] - F(X[n])/F'(X[n]),
     * ����x[n]Ϊ��n�����ô˹�ʽ���ֵ��
     * ���纯��F(X) = X^m - a, �����ţ�ٵ�������n+1���󷽳�F(x) = 0�Ľ�ΪX[n+1]��
     * ��X[n+1] = (1-1/m)*X[n] +a/(n*X[n]^(m-1))  -  (X[n]*X[n]*X[n]+a)/3*X[n]*X[n]��
     *
     * @param x
     * @return
     */
    private static double getCubeRoot(double x) {

        double x0;
        double x1 = x;
        do {
            x0 = x1;
            x1 = 2.0 / 3.0 * x0 + x / 3.0 / (x0 * x0);
        } while (Math.abs(x1 - x0) > 0.000001);

        return x1;
    }
}

