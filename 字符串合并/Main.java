package �ַ����ϲ�;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str01 = in.next();
            String str02 = in.next();
            String out = ProcessString(str01, str02);
            System.out.println(out);
        }
        in.close();
    }
    public static String ProcessString(String str1, String str2) {
        String strCombine = str1 + str2;
        int len = strCombine.length();
         
        List<Character> s1 = new ArrayList<Character>();
        List<Character> s2 = new ArrayList<Character>();
         
        StringBuffer sb = new StringBuffer();
        StringBuffer sbOut = new StringBuffer();
        int i, j = 0, k = 0;
        for (i = 0; i < len; i++) {
            if (i % 2 == 0) {
                s1.add(strCombine.charAt(i));
            } else {
                s2.add(strCombine.charAt(i));
            }
        }
        Collections.sort(s1); //�±�Ϊż��λ�ַ�����
        Collections.sort(s2); //�±�Ϊ����λ�ַ�����
        for (i = 0; i < len; i++) { //��ż��λ������λ�ַ��ϲ�
            if (i % 2 == 0) {
                sb.append(s1.get(j++));
            } else {
                sb.append(s2.get(k++));
            }
        }
        for (i = 0; i < len; i++) {
             String cTmp = sb.substring(i, i + 1);
             if (cTmp.matches("[0-9a-fA-F]")) { //����ַ���16�����ַ������д�������ʲôҲ����
                 int iTmp = Integer.parseInt(cTmp, 16);
                 String sTmp = Integer.toBinaryString(iTmp);
                 StringBuffer sbTmp = new StringBuffer();
                 for (j = sTmp.length(); j < 4; j++) {
                     sbTmp.append("0");
                 }
                 sbTmp.append(sTmp);
                 sbOut.append(Integer.toHexString(Integer.parseInt(sbTmp.reverse().toString(), 2)).toUpperCase());
             } else {
                 sbOut.append(cTmp);
             }
              
        }
        return sbOut.toString();
    }
}