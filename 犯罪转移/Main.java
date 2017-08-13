/**
 * 
 */
/**
 * @author Administrator
 *
 */
package 犯罪转移;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();//n个人
            int t = in.nextInt();//
            int c = in.nextInt();//连续c名
            int[] a = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
            }
            int count = 0;
            int tempt = 0;
            for(int i = 0;i<c;i++){
                tempt += a[i];
            }
            if(tempt<=t)
                count++;
           for(int i = c;i<a.length;i++){
               tempt = tempt+a[i]-a[i-c];
               if(tempt<=t)
                count++;
           }
           System.out.println(count);
        }
    }
}