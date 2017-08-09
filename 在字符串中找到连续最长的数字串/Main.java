package 在字符串中找到连续最长的数字串;

import java.util.Scanner;

public class Main{//子串系列，简单动态规划，dp[i]代表当前i的最长数字长度
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int len = str.length();
            int max = 0;
            int dp[] = new int[len];
            int flag =0;
            //动态规划边界
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