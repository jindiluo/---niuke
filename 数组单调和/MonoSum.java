/**
 *
 */
/**
 * @author Administrator
 *
 */
package 数组单调和;

import java.util.Arrays;

public class MonoSum {
    public int calcMonoSum(int[] A, int n) {
        // write code here
        int len =A.length;
        int[] dandiao = new int[len];
        //初始化
        for(int i=0;i<len;i++){
            dandiao[i] = 0;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(A[j]<=A[i]){
                    if(dandiao[i]<=dandiao[j]+A[j]){
                        dandiao[i]=dandiao[j]+A[j];
                    }else{
                        dandiao[i] = dandiao[i]+A[j];
                    }

                }

            }
        }
        System.out.println(Arrays.toString(dandiao));
        int res = 0;
        for(int i=0;i<dandiao.length;i++){
            res = res+dandiao[i];
        }

        return res;
    }
}