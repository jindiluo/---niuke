/**
 * 
 */
/**
 * @author Administrator
 *
 */
package ��Բ��;

/*�Ҿ�������һ����ѧ�� = =��
    ���ű�Ե��ת��ÿ���ƶ���Բ�Ŀ����ƶ��Ծ�Բ��ΪԲ�ģ�2rΪ�뾶��Բ��Χ������һ��
����ÿ�����������յ������ƶ���ÿ��2r������2r��1�Ρ�
����ceil��d/2r������
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