package ���ַ������ҵ�����������ִ�;

import java.util.Scanner;

public class Main{//�Ӵ�ϵ�У��򵥶�̬�滮��dp[i]����ǰi������ֳ���
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int len = str.length();
            int max = 0;
            int dp[] = new int[len];
            int flag =0;
            //��̬�滮�߽�
            if (str.charAt(0)>='0'&&str.charAt(0)<='9') {

                dp[0]=1;
            }
            for (int i = 1; i < len; i++) {
                if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
                    dp[i]=dp[i-1]+1;
                }else {
                    dp[i]=0;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                if (dp[i]>max) {
                    max = dp[i];
                    flag = i;
                }
            }
            String temp = "";
            for (int i = 0; i < dp.length; i++) {
                if (dp[i]==max) {
                    temp+=str.substring(i-max+1,i+1);
                }
            }
            //System.out.println(str.substring(flag-max+1,flag+1)+","+max);
            System.out.println(temp+","+max);
        }
    }
}