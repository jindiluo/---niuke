package �������������;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {

            String n = scanner.next();
            String m = scanner.next();
            // ��1������һ
            System.out.println(addLongInteger(n, m));

            // ��2��������
//            BigInteger bi1 = new BigInteger(n);
//            BigInteger bi2 = new BigInteger(m);
//            System.out.println(bi1.add(bi2));
        }

        scanner.close();
    }

    /**
     * ��������ӣ�ns��ms����С��0
     *
     * @param ns ����
     * @param ms ����
     * @return ���
     */
    private static String addLongInteger(String ns, String ms) {
        int[] n = getNumber(ns);
        int[] m = getNumber(ms);
        // ���м���
        int[] r = add(m, n);

        return toNumber(r);
    }

    /**
     * ������С������������
     *
     * @param m ����
     * @param n ����
     * @return ���
     */
    private static int[] add(int[] m, int[] n) {

//        System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m));

        // ��֤n��С��m
        if (m.length > n.length) {
            int[] t = m;
            m = n;
            n = t;
        }

        // �������󳤶�
        int[] r = new int[n.length + 1];
        // ���Ե�λ�Ľ�λ
        int c = 0;

        for (int i = 0; i < m.length; i++) {
            r[i] = m[i] + n[i] + c;
            c = r[i] / 10;
            r[i] %= 10;
        }

        // �������µĲ���
        for (int i = m.length; i < n.length; i++) {
            r[i] = n[i] + c;
            c = r[i] / 10;
            r[i] %= 10;
        }

//        System.out.println(Arrays.toString(n) +"\n"+ Arrays.toString(m) + "\n" + Arrays.toString(r));

        // ����н�λ
        if (c != 0) {
            r[r.length - 1] = c;
            return r;
        }
        // û�н�λ
        else {
            int[] ret = new int[r.length - 1];
            System.arraycopy(r, 0, ret, 0, ret.length);
            return ret;
        }
    }


    /**
     * �������ַ�����ʾ���������顾����������λ��
     *
     * @param n �����ַ���
     * @return �������� �±��С�����ʾ��λ�Ĵӵ͵���
     */
    private static int[] getNumber(String n) {
        int[] r = new int[n.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = n.charAt(n.length() - i - 1) - '0';
        }

        return r;
    }

    /**
     * �������ʾ������ת�����ַ���
     *
     * @param r ����
     * @return �ַ�����ʾ������
     */
    private static String toNumber(int[] r) {
        if (r == null) {
            return null;
        }

        StringBuilder b = new StringBuilder(r.length);

        for (int i = r.length - 1; i >= 0; i--) {
            b.append(r[i]);
        }

        return b.toString();
    }
}
