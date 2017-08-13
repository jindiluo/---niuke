/**
 * 
 */
/**
 * @author Administrator
 *
 */
package 搬圆桌;

/*我觉得这是一道数学题 = =。
    沿着边缘旋转，每次移动，圆心可以移动以旧圆心为圆心，2r为半径的圆范围内任意一点
所以每次沿着起点和终点连线移动，每次2r，不足2r算1次。
所以ceil（d/2r）即可
*/
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args){
        int r,x,y,x1,y1;
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            r=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
            x1=sc.nextInt();
            y1=sc.nextInt();
            double d=Math.sqrt(Math.pow(x1-x, 2)+Math.pow(y1-y, 2));
            int res=(int) Math.ceil(d/(2*r));
            System.out.println(res);
        }
    }
}