package �ж�����ip�Ƿ�����ͬһ����;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String subnet = scanner.next();
            String ip1 = scanner.next();
            String ip2 = scanner.next();

            System.out.println(subnetJudgement(subnet, ip1, ip2));
        }

        scanner.close();
    }

    private static int subnetJudgement(String subnet, String ip1, String ip2) {

        //  1��IP��ַ�����������ʽ�Ƿ�
        if (!ipValidate(subnet) || !ipValidate(ip1) || !ipValidate(ip2)) {
            return 1;
        }

        int subnetInt = ipStrToInt(subnet);

        //  1�����������ʽ�Ƿ�
        if (!subnetMaskValidate(subnetInt)) {
            return 1;
        }

        int b = ipStrToInt(ip2);
        int a = ipStrToInt(ip1);

        // 0��IP1��IP2����ͬһ������
        if ((a & subnetInt) == (b & subnetInt)) {
            return 0;
        }
        // 2��IP1��IP2������ͬһ������
        else {
            return 2;
        }



    }

    /**
     * ��֤IP��ַ�ĸ�ʽ�Ƿ���ȷ
     *
     * @param ip IP��ַ
     * @return true����ʽ��ȷ��false����ʽ����ȷ
     */
    private static boolean ipValidate(String ip) {
        String[] part = ip.split("\\.");

//        if (part.length != 4) {
//            return false;
//        }

        for (String s : part) {
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return true;
    }

    /**
     * ����������֤������Ų���ȫΪ��1���������Ų���ȫΪ��0��
     *
     * @param ip
     * @return
     */
    private static boolean subnetMaskValidate(int ip) {
        boolean hasZero = false;
        int and = 0x80000000;
        while (and != 0) {
            // �������λλ��Ϊ0
            if ((ip & and) == 0) {
                // ˵��������0
                hasZero = true;
            }
            // ���λ��Ϊ1
            else {
                // ֮ǰ�Ѿ���0���ֹ�����˵��1�ǲ������ģ������������벻�Ϸ�
                if (hasZero) {
                    return false;
                }
            }

            // �޷�������һλ
            and >>>= 1;
        }

        return true;
    }

    /**
     * �����ʮ���Ƶ�IP��ַת����������ʾ
     *
     * @param ip ���ʮ���Ƶ�IP��ַ
     * @return IP��ַ��������
     */
    private static int ipStrToInt(String ip) {
        String[] part = ip.split("\\.");
        int intIP = 0;

        for (int i = 0; i < part.length; i++) {
            int t = Integer.parseInt(part[i]);
            intIP += t << (24 - 8 * i);
        }

        return intIP;
    }
}

