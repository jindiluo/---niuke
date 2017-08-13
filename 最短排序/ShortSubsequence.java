/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最短排序;


import java.util.Arrays;

public class ShortSubsequence {
    public int findShortest(int[] A, int n) {
        // write code here
        int[] B=new int[n];
        B=Arrays.copyOf(A,n);//复制数组A为B
        Arrays.sort(B);
        boolean flag=true;//标记记录原数组是否有序，true代表有序。
        int start=0;
        int end=n-1;
        for(int i=0;i<n;i++)//从原数组的头部找需要被排序的角标start
        {
            if(A[i]!=B[i])
            {
                flag=false;//有不相同的部分，代表数组无序。
                start=i;
                break;
            }

        }
        if(flag)
            return 0;//全部有序，则没有需要被排序的子数组。返回0。
        for(int j=n-1;j>=0;j--)//从原数组的尾部找需要被排序的角标end
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

