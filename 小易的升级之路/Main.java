/**
 *
 */
/**
 * @author Administrator
 *
 */
package С�׵�����֮·;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //�ȹ����Ӧ�����������ʽ
        Scanner scanner=new Scanner(System.in);
        //��ȡ�����ж�
        while(scanner.hasNext())
        {
            //��ʼ��
            int n=scanner.nextInt();
            int init=scanner.nextInt();
            int[] monster=new int [n];
            for(int i=0;i<n;i++)
            {
                //��ȡ��Ӧ����ֵ
                monster[i]=scanner.nextInt();
                if(init>monster[i])
                {
                    init+=monster[i];
                }
                else
                {
                    //��ʱ��һ��monster��
                    init+=GetGYS(init,monster[i]);
                }
            }
            System.out.println(""+init);
        }
        //�ر�scanner
        scanner.close();
    }

    //��ȡ��Ӧ���Լ��
    public static int GetGYS(int n,int m)
    {
        if(m%n==0)
            return n;
        else
        {
            return GetGYS(m%n,n);
        }

    }
}