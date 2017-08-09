package �����ַ��������ƶ�;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println("1/" + (stringDistance(a.toCharArray(), b.toCharArray()) + 1));
        }

        scanner.close();
    }

    /**
     * �ܾ���Ŀ�ʹ�ö�̬�滮�����������Ŀ���ͼ������ַ�������������������ơ�
     * <p>
     * ��AiΪ�ַ���A(a1a2a3 �� am)��ǰi���ַ�����Ϊa1,a2,a3 �� ai��
     * ��BjΪ�ַ���B(b1b2b3 �� bn)��ǰj���ַ�����Ϊb1,b2,b3 �� bj��
     * <p>
     * �� L(i,j)Ϊʹ�����ַ�����Ai��Bj��ȵ���С����������
     * ��ai==bjʱ ��Ȼ L(i,j) = L(i-1,j-1)
     * ��ai!=bjʱ
     * <p>
     * ���������޸�Ϊ��ȣ���������ַ������ٻ�Ҫ����L(i-1,j-1)��
     * ��ɾ��ai����bj�����ai����������ַ������ٻ�Ҫ����L(i-1,j)��
     * ��ɾ��bj����ai�����bj����������ַ������ٻ�Ҫ����L(i,j-1)��
     * ��ʱL(i,j) = min( L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1
     * <p>
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

