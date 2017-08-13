/**
 *
 */
/**
 * @author Administrator
 *
 */
package 炮台攻击;


import java.util.Scanner;
//我是第一次在线练习笔试，看了大家的才知道不能随便取名。之前取名Test编译都通不过。
public class Main{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        int R,x1,y1,x2,y2,x3,y3,x0,y0;
        //System.out.println("请输入R、x1,y1,x2,y2,x3,y3,x0,y0");

//不能随便输出东西，只能输出结果
        while(reader.hasNext()){
            int sum = 0;//每轮数据初始化
             R = reader.nextInt();
            x1 = reader.nextInt();
            y1 = reader.nextInt();
            x2 = reader.nextInt();
            y2 = reader.nextInt();
            x3 = reader.nextInt();
            y3 = reader.nextInt();
            x0 = reader.nextInt();
            y0 = reader.nextInt();
            if (getSum(x1,y1,x0,y0,R) == 1){
                sum++;
            }
            if(getSum(x2,y2,x0,y0,R) == 1){
                sum++;
            }
            if(getSum(x3,y3,x0,y0,R) ==1){
                sum++;
            }
            System.out.println(sum+"x");
        }
    }
    private static int getSum(int x,int y, int m,int n,int r){
        if( ((m-x)*(m-x) +(n-y)*(n-y)) <= (r*r ) ){
            return 1;//在范围内返回1
        }
        else{
            return 0;//范围外返回0
        }
    }
}