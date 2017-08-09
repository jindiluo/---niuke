package �����ַ����ľ���;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(stringDistance(a, b));

        }

        scanner.close();
    }

    private static int stringDistance(String a, String b) {
//        System.out.println(stringDistance(a.toCharArray(), 0, b.toCharArray(), 0));
        return stringDistance(a.toCharArray(), b.toCharArray());
    }


    /**
     * ����һ������������
     * <pre>
     * �����ַ����ľ���϶����������ǵĳ���֮�ͣ����ǿ���ͨ��ɾ����������������ת��Ϊ�մ�����
     * ��Ȼ������۶Խ��û�а����������ٿ���֪�������������ַ����ľ��붼�����޵ġ�
     * ���ǻ���Ӧ�ü��п�����β��ܰ��������ת���ɹ�ģ��С��ͬ�������⡣
     * �����������A=xabcdae��B=xfdfa�����ǵĵ�һ���ַ�����ͬ�ģ�ֻҪ����A[2,��,7]=abcdae
     * ��B[2,��,5]=fdfa�ľ���Ϳ����ˡ���������������ĵ�һ���ַ�����ͬ��
     * ��ô���Խ������µĲ�����lenA��lenB�ֱ���A����B���ĳ��ȣ���
     * 1��ɾ��A���ĵ�һ���ַ���Ȼ�����A[2,��,lenA]��B[1,��,lenB]�ľ��롣
     * 2��ɾ��B���ĵ�һ���ַ���Ȼ�����A[1,��,lenA]��B[2,��,lenB]�ľ��롣
     * 3���޸�A���ĵ�һ���ַ�ΪB���ĵ�һ���ַ���Ȼ�����A[2,��,lenA]��B[2,��,lenB]�ľ��롣
     * 4���޸�B���ĵ�һ���ַ�ΪA���ĵ�һ���ַ���Ȼ�����A[2,��,lenA]��B[2,��,lenB]�ľ��롣
     * 5������B���ĵ�һ���ַ���A���ĵ�һ���ַ�֮ǰ��Ȼ�����A[1,��,lenA]��B[2,��,lenB]�ľ��롣
     * 6������A���ĵ�һ���ַ���B���ĵ�һ���ַ�֮ǰ��Ȼ�����A[2,��,lenA]��B[1,��,lenB]�ľ��롣
     *
     * �������Ŀ�У����ǲ����ں������ַ���������֮����ַ����������ġ����ԣ����Խ�����6�������ϲ�Ϊ��
     * 1.һ������֮���ٽ�A[2,��,lenA]��B[1,��,lenB]�����ͬ�ַ�����
     * 2.һ������֮���ٽ�A[1,��,lenA]��B[2,��,lenB]�����ͬ�ַ�����
     * 3.һ������֮���ٽ�A[2,��,lenA]��B[2,��,lenB]�����ͬ�ַ�����
     * </pre>
     *
     * @param a
     * @param i
     * @param b
     * @param j
     * @return
     */
    private static int stringDistance(char[] a, int i, char[] b, int j) {

        if (i >= a.length || j >= b.length) {
            return Math.max(a.length - i, b.length - j);
        }

        // �ַ����
        if (a[i] == b[j]) {
            return stringDistance(a, i + 1, b, j + 1);
        } else {
            int d1 = stringDistance(a, i + 1, b, j);
            int d2 = stringDistance(a, i + 1, b, j + 1);
            int d3 = stringDistance(a, i, b, j + 1);

            return Math.min(Math.min(d1, d2), d3) + 1;
        }
    }

    /**
     * ������
     * <pre>
     * �ܾ���Ŀ�ʹ�ö�̬�滮�����������Ŀ���ͼ������ַ�������������������ơ�
     *
     * ��AiΪ�ַ���A(a1a2a3 �� am)��ǰi���ַ�����Ϊa1,a2,a3 �� ai��
     * ��BjΪ�ַ���B(b1b2b3 �� bn)��ǰj���ַ�����Ϊb1,b2,b3 �� bj��
     *
     * �� L(i,j)Ϊʹ�����ַ�����Ai��Bj��ȵ���С����������
     * ��ai==bjʱ ��Ȼ L(i,j) = L(i-1,j-1)
     * ��ai!=bjʱ
     *
     *  ���������޸�Ϊ��ȣ���������ַ������ٻ�Ҫ����L(i-1,j-1)��
     *  ��ɾ��ai����bj�����ai����������ַ������ٻ�Ҫ����L(i-1,j)��
     *  ��ɾ��bj����ai�����bj����������ַ������ٻ�Ҫ����L(i,j-1)��
     *  ��ʱL(i,j) = min( L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1
     *
     * ��Ȼ��L(i,0)=i��L(0,j)=j, �����������ĵ��ƹ�ʽ������ֱ�Ӽ����L(i,j)ֵ��
     * </pre>
     *
     * @param a
     * @param b
     * @return
     */
    private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }

        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }

        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }

        return len[len.length - 1][len[0].length - 1];
    }
}

