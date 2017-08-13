/**
 * 
 */
/**
 * @author Administrator
 *
 */
package 钓鱼比赛;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt(), m = in.nextInt(),
                    x = in.nextInt(), y = in.nextInt(), t = in.nextInt();
            in.nextLine();  // 需将换行符读掉
            double p1 = 0, p2 = 0;  // p1,p2 为cc, ss一条鱼都钓不到的概率
            for (int i = 0; i < n; i++){
                String[] arr = in.nextLine().split(" "); // 按行读取降低时间复杂度
                for (int j = 0; j < m; j++){
                    double p = Double.parseDouble(arr[j]);
                    p1 = (i == x-1 && j == y-1) ? 1-p : p1;
                    p2 += 1-p ;
                }
            }
            p2 = p2 / (n * m);
            double _p1 = p1, _p2 = p2;
            while (t-- > 1){  // 计算钓 t 分钟钓不到鱼的概率
                p1 *= _p1;
                p2 *= _p2;
            }
            System.out.println(p1 == p2 ? "equal" : (p1 < p2 ? "cc" : "ss"));
            System.out.printf("%.2f\n", 1-Math.min(p1, p2)); 
        }
    }
}