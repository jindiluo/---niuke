/**
 *
 */
/**
 * @author Administrator
 *
 */
package ��̨����;


import java.util.Scanner;
//���ǵ�һ��������ϰ���ԣ����˴�ҵĲ�֪���������ȡ����֮ǰȡ��Test���붼ͨ������
public class Main{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        int R,x1,y1,x2,y2,x3,y3,x0,y0;
        //System.out.println("������R��x1,y1,x2,y2,x3,y3,x0,y0");

//����������������ֻ��������
        while(reader.hasNext()){
            int sum = 0;//ÿ�����ݳ�ʼ��
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
            return 1;//�ڷ�Χ�ڷ���1
        }
        else{
            return 0;//��Χ�ⷵ��0
        }
    }
}