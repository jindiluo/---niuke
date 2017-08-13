/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最大间隔;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a;
        while(in.hasNext()){
            int n = in.nextInt();
            a = new int[n];
            for(int i=0; i<n;i++){
                a[i] = in.nextInt();
            }
            int maxDisMin = findMin(n, a);
            System.out.println(maxDisMin);
        }
    }

    public static int findMin(int n, int[] a){
        //初始化最大间隔
        int maxDis = 0;
        //初始化最大间隔最小值
        int maxDisMin = a[n-1] - a[0];
        //找出此序列未删除任何元素之前的最大间隔
        for(int j=0; j<n-1; j++){
            if(a[j+1] - a[j] > maxDis){
                maxDis = a[j+1] - a[j];
            }
        }
        //遍历删除元素a[i]（1<=i<=n-2）
        for(int i=1; i<n-1; i++){
            //初始化删除后最大间隔maxDisDel为未删除的最大间隔maxDis
            int maxDisDel = maxDis;
            if(a[i+1] - a[i-1] > maxDis){
                //如果a[i]前后两元素之差大于maxDis,更新maxDisDel
                 maxDisDel = a[i+1] - a[i-1];
            }
            if(maxDisDel < maxDisMin){
                //如果最大间隔小于maxDisMin，更新maxDisMin
                maxDisMin = maxDisDel;
            }
        }
        return maxDisMin;
    }
}