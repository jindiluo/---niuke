/**
 *
 */
/**
 * @author Administrator
 *
 */
package �������;


import java.util.Arrays;

public class ShortSubsequence {
    public int findShortest(int[] A, int n) {
        // write code here
        int[] B=new int[n];
        B=Arrays.copyOf(A,n);//��������AΪB
        Arrays.sort(B);
        boolean flag=true;//��Ǽ�¼ԭ�����Ƿ�����true��������
        int start=0;
        int end=n-1;
        for(int i=0;i<n;i++)//��ԭ�����ͷ������Ҫ������ĽǱ�start
        {
            if(A[i]!=B[i])
            {
                flag=false;//�в���ͬ�Ĳ��֣�������������
                start=i;
                break;
            }

        }
        if(flag)
            return 0;//ȫ��������û����Ҫ������������顣����0��
        for(int j=n-1;j>=0;j--)//��ԭ�����β������Ҫ������ĽǱ�end
        {
            if(A[j]!=B[j])
            {
                end=j;
                break;
            }


        }
        return end-start+1;

    }
}

