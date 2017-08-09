package �߾��ȼӷ�;



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data3.txt"));
        while (scanner.hasNext()) {

            String n = scanner.next();
            String m = scanner.next();
            // ��1������һ
            System.out.println(add(n, m));

            // ��2��������
//            BigInteger bi1 = new BigInteger(n);
//            BigInteger bi2 = new BigInteger(m);
//            System.out.println(bi1.add(bi2));
        }

        scanner.close();
    }

    /**
     * ���������
     *
     * @param ns ����
     * @param ms ����
     * @return ���
     */
    private static String add(String ns, String ms) {


        // ns�Ƿ�Ϊ����
        boolean pn = ns.charAt(0) != '-';
        // ms�Ƿ�Ϊ����
        boolean pm = ms.charAt(0) != '-';

        int[] n;
        int[] m;
        if (pn) {
            n = getNumber(ns);
        } else {
            n = getNumber(ns.substring(1));
        }

        if (pm) {
            m = getNumber(ms);
        } else {
            m = getNumber(ms.substring(1));
        }


        // ����ͬ��
        if (pn == pm) {
            // ���м���
            int[] r = add(m, n);
            String rs = toNumber(r);

            // ������Ҫ��Ӹ���
            if (pn) {
                return rs;
            } else {
                return "-" + rs;
            }
        } else {
            // ns�ľ���ֵ�ȴ��ڵ���ms
            if (compare(n, m) >= 0) {
                int[] r = minus(n, m);
                String rs = toNumber(r);
                // nsΪ������msΪ����
                if (pn) {
                    return rs;
                } else {
                    return "-" + rs;
                }
            }
            // ns�ľ���ֵ��С��ms
            else {
                int[] r = minus(m, n);
                String rs = toNumber(r);

                // nsΪ������msΪ����
                if (pn) {
                    return "-" + rs;

                } else {
                    return rs;
                }
            }
        }
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
     * �Ƚ����������Ƿ���ȣ��±���С�����ʾ�ɵ�λ����λ�����������Чλ�ϵ�ǰ��0
     *
     * @param m ����
     * @param n ����
     * @return m > n����1��m = n����0��m < n����-1
     */
    private static int compare(int[] m, int[] n) {

        if (m == null && n == null) {
            return 0;
        }
        // null��С
        if (m == null) {
            return -1;
        }

        if (n == null) {
            return 1;
        }

        int lastM = m.length - 1;
        int lastN = n.length - 1;

        // ��m�������Чλ��λ�ã�������һλ
        while (lastM >= 1 && m[lastM] == 0) {
            lastM--;
        }
        // ��n�������Чλ��λ�ã�������һλ
        while (lastN >= 1 && n[lastN] == 0) {
            lastN--;
        }

        // m����λ��n�࣬˵��m��n��
        if (lastM > lastN) {
            return 1;
        }
        // m����λ��n�٣�˵��m��nС
        else if (lastM < lastN) {
            return -1;
        } else {
            // λ��һ�����Ƚ�ÿһ����λ�ϵ�ֵ���Ӹ�λ����λ���бȽ�
            for (int i = lastM; i >= 0; i--) {
                if (m[i] > n[i]) {
                    return 1;
                } else if (m[i] < n[i]) {
                    return -1;
                }
            }

            return 0;
        }
    }


    /**
     * ������n-m����֤n���ڵ���m
     *
     * @param n ����
     * @param m ����
     * @return ���
     */
    private static int[] minus(int[] n, int[] m) {

        n = format(n);
        m = format(m);

        int[] r = new int[n.length];

        // ��ǰλ����λ
        int c = 0;
        int t;
        for (int i = 0; i < m.length; i++) {
            t = n[i] - c - m[i];
            // ��ǰλ����
            if (t >= 0) {
                r[i] = t;
                // û�н��н�λ
                c = 0;
            }
            // ������
            else {
                r[i] = t + 10;
                // ���н�λ
                c = 1;
            }
        }


        // ���н�λ����n��mλ���࣬Ҫ��n�е���λ���Ƶ�r��
        for (int i = m.length; i < n.length; i++) {
            t = n[i] - c;
            // ��ǰλ����
            if (t >= 0) {
                r[i] = t;
                // û�н��н�λ
                c = 0;
            }
            // ������
            else {
                r[i] = t + 10;
                // ���н�λ
                c = 1;
            }
        }

//        System.out.println(Arrays.toString(r));

        return format(r);
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
     * ���������и�ʽ����ȥ����λ��ǰ��0
     *
     * @param r ����
     * @return ���
     */
    private static int[] format(int[] r) {
        int t = r.length - 1;
        // �������Чλ
        while (t > 0 && r[t] == 0) {
            t--;
        }

        int[] nr = new int[t + 1];
        System.arraycopy(r, 0, nr, 0, nr.length);
        return nr;

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

