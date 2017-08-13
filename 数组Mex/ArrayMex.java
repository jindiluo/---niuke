/**
 *
 */
/**
 * @author Administrator
 *
 */
package Êı×éMex;



public class ArrayMex {
    public int findArrayMex(int[] A, int n) {
        // write code here
        int res[]=new int[501];
        for(int i=0;i<n;i++){
            if(A[i]>500) continue;
            else if(A[i]>0){
                res[A[i]]=1;
            }
        }
        int m;
        for(m=1;m<501;m++){
            if(res[m]==0) break;
        }
        return m;

    }
}
