/**
 *
 */
/**
 * @author Administrator
 *
 */
package 路灯;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int n = in.nextInt();
            int l = in.nextInt();
            int[] a = new int[n];
            int max = 0;
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
            }
            sort(a);
            int star = 0;
            for(int i = 0;i<n;i++){
                int d = a[i]-star;
                star = a[i];
                max = d>max?d:max;
            }
            if(a[n-1]!=l){
                int r = l-a[n-1];//比较特殊终点不是一盏灯
                max = r*2>max?r*2:max;

            }
            String result = String.format("%.2f",max/2.00);
            System.out.println(result);
        }
    }

    public static void sort(int[] a){

        for(int i = 0;i<a.length-1;i++){
            boolean flag = true;
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if(flag)
                return;
        }
    }
}