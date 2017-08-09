package ip��ַ����;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {
    private static int a = 0; // A��IP
    private static int b = 0; // B��IP
    private static int c = 0; // C��IP
    private static int d = 0; // D��IP
    private static int e = 0; // E��IP
    private static int error = 0; // ����IP
    private static int pri = 0; // ˽��IP

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            checkIp(s);
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + pri);
        scanner.close();

    }

    private static void checkIp(String s) {
        String[] str = s.split("~");
        String ip = str[0];
        String mask = str[1];
        String[] ipParts = ip.split("\\.");
        String[] maskParts = mask.split("\\.");

        int[] ipInts = new int[4];
        int[] maskInts = new int[4];

        // �ж�IP�Ƿ���4�������
        if (ipParts.length != 4 || maskParts.length != 4) {
            error++;
            return;
        }

        // �ж�IP�е�ÿһ���ָ�ʽ
        for (int i = 0; i < 4; i++) {
            if (" ".equals(ipParts[i]) || " ".equals(maskParts[i])) {
                error++;
                return;
            }
        }

        // ��IP����������
        for (int i = 0; i < 4; i++) {
            ipInts[i] = Integer.parseInt(ipParts[i]);
            maskInts[i] = Integer.parseInt(maskParts[i]);
            if (ipInts[i] > 255 || maskInts[i] > 255) {
                error++;
                return;
            }
        }

        // ������ת�ɶ����Ƹ�ʽ
        String temp = "";
        for (int i = 0; i < maskParts.length; i++) {
            BigInteger bi = new BigInteger(maskParts[i]);
            temp += bi.toString(2);

        }

        // ����������Ƹ�ʽ�еĵ�һ��0λ��
        int index = temp.indexOf("0");
        temp = temp.substring(index + 1);

        // �����У���һ��0�������1˵�����벻�Ϸ�
        if (temp.contains("1")) {
            error++;
            return;
        }


        if (ipInts[0] >= 1 && ipInts[0] <= 126) {
            a++;
        }

        if (ipInts[0] >= 128 && ipInts[0] <= 191) {
            b++;
        }

        if (ipInts[0] >= 192 && ipInts[0] <= 223) {
            c++;
        }

        if (ipInts[0] >= 224 && ipInts[0] <= 239) {
            d++;
        }
        if (ipInts[0] >= 240 && ipInts[0] <= 255) {
            e++;
        }

        if (ipInts[0] == 10) {
            pri++;
        }

        if (ipInts[0] == 172) {
            if (ipInts[1] >= 16 && ipInts[1] <= 31) {
                pri++;
            }
        }

        if (ipInts[0] == 192) {
            if (ipInts[1] == 168) {
                pri++;
            }
        }

    }

}

