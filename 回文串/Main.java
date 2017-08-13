/**
 * 
 */
/**
 * @author Administrator
 *
 */
package 回文串;
import java.util.*;

public class Main{
//思路：循环遍历每次删除其中一个字符之后判断是不是回文。
    public static boolean isHuiwen(String str,int n){
        int temp=n/2;
        for(int i=0;i<temp;i++){
            if(str.charAt(i)!=str.charAt(n-i-1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.next();
            int n = s.length();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (i != n - 1) {
                    if (isHuiwen(s.substring(0, i) + s.substring(i + 1), n-1)) {
                        flag = true;
                        break;
                    }
                } else {
                    if (isHuiwen(s.substring(0, n - 1), n - 1)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
