/**
 *
 */
/**
 * @author Administrator
 *
 */
package �����;
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
        //��ʼ�������
        int maxDis = 0;
        //��ʼ���������Сֵ
        int maxDisMin = a[n-1] - a[0];
        //�ҳ�������δɾ���κ�Ԫ��֮ǰ�������
        for(int j=0; j<n-1; j++){
            if(a[j+1] - a[j] > maxDis){
                maxDis = a[j+1] - a[j];
            }
        }
        //����ɾ��Ԫ��a[i]��1<=i<=n-2��
        for(int i=1; i<n-1; i++){
            //��ʼ��ɾ���������maxDisDelΪδɾ���������maxDis
            int maxDisDel = maxDis;
            if(a[i+1] - a[i-1] > maxDis){
                //���a[i]ǰ����Ԫ��֮�����maxDis,����maxDisDel
                 maxDisDel = a[i+1] - a[i-1];
            }
            if(maxDisDel < maxDisMin){
                //��������С��maxDisMin������maxDisMin
                maxDisMin = maxDisDel;
            }
        }
        return maxDisMin;
    }
}