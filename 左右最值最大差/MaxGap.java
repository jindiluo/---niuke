/**
 *
 */
/**
 * @author Administrator
 *
 */
package 左右最值最大差;



public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int mmax = -1;
        for(int k = 0 ; k < n -1 ; k ++){
            int maxLeft = -1;
            int maxRight = -1;
            for(int i = 0 ; i < n ; i ++){
                if(i <= k){
                    maxLeft = Math.max(maxLeft,A[i]);
                }else {
                    maxRight = Math.max(maxRight,A[i]);
                }
            }
            mmax = Math.max(Math.abs(maxLeft-maxRight),mmax);
        }
        return mmax;
    }
}