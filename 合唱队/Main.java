package �ϳ���;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(countChorus(arr));
        }

        scanner.close();
    }

    /**
     * <pre>
     * ����˼·
     * էһ�����������޴����֣��Ѳ���Ҫö�ٳ����е�������ܵó������һ����˵�ǲ���������ö�������������ġ�
     * ʵ��������һ���򵥶�̬�滮���⡣����һ�ۿ���ȥ���Ǻ�ֱ�ۡ���Ŀ��ν�ĺϳ����ξ���һ������������е�ƴ�ӡ�
     * ֻҪ����Ӷ����׵�λ�� i ������������г��ȼ��ϴӶ�β��ʼ��λ�� i ������������еĳ��Ⱦ�������ϳ���
     * �ε��ܳ��ȡ� ���ǻ�֪���ܵ���������һ�¾��ܵó�Ҫ���е������ˡ�
     *
     * �������������
     * ������һ�����У�Ҫ����������������С�ֱ���ϲ����Ǻܺ���ã����������Ļ����ܱȽϺ���⣺
     * ���ڶ�����������ĵ�i��Ԫ����˵������Ԫ��i����������Ƕ����أ����iǰ�����ܹ�����������еģ�����Ϊj����
     * ����i��ֵ��j���Ǻ���Ȼ����i��Ԫ��(����Ԫ��i)����������ǵ���j��Ԫ�ص��������+1�����򵽵�i��Ԫ��
     * (����Ԫ��i)��������о�����1����Ϊǰ��û�б�����С���ˣ�ֻ��������һ�������С�
     * </pre>
     *
     * @param arr
     * @return
     */
    private static int countChorus(int[] arr) {

        int[] ltr = getRiseLongestSequenceLeftToRight(arr);
        int[] rtl = getRiseLongestSequenceRightToLeft(arr);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < ltr[i] + rtl[i]) {
                max = ltr[i] + rtl[i] - 1;
            }
        }

        return arr.length - max;
    }

    private static int[] getRiseLongestSequenceLeftToRight(int[] arr) {
        int[] ltr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ltr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && ltr[i] <= ltr[j]) {
                    ltr[i] = ltr[j] + 1;
                }
            }
        }

        return ltr;
    }

    private static int[] getRiseLongestSequenceRightToLeft(int[] arr) {
        int[] rtl = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            rtl[i] = 1;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j] && rtl[i] <= rtl[j]) {
                    rtl[i] = rtl[j] + 1;
                }
            }
        }

        return rtl;
    }

}
