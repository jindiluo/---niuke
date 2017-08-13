/**
 *
 */
/**
 * @author Administrator
 *
 */
package ×Ö·û´®¼ÆÊý;

import java.util.Scanner;
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long result = 0;
            String begin = sc.next();
            String end = sc.next();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            int maxlen = begin.length()>end.length()?begin.length():end.length();
            int minlen = begin.length()<end.length()?begin.length():end.length();
            for(int i=0;i<maxlen;i++){
                int distance;
                if(i<minlen){
                    distance = end.charAt(i)-begin.charAt(i);

                }else{
                    if(begin.length()>end.length())
                        distance = 'a' - begin.charAt(i)-1;
                    else
                        distance = end.charAt(i)-'a'+1;
                }
                long now=0;
                for(int j=len1;j<=len2;j++){
                    if(j-i-1>=0){
                        now=now+(long)Math.pow(26,j-i-1);
                    }
                }
                now = (now*distance)%1000007;
                result+=now;
            }
            System.out.println(result-1);
        }
    }
}