/**
 *
 */
/**
 * @author Administrator
 *
 */
package 相邻最大差值;


public class MaxDivision {
    private static int min =0;
    private static int max=0;
    public int findMaxDivision(int[] A, int n) {
        // write code here
        int index[] = getM(A, n);
        for(int i=0; i<n; i++){
            index[A[i]-min] = 1;
        }
        int rst = 0;
        for(int i=0; i<max-min+1; i++){
            int j = i;
            while(j<max-min+1&&index[j]==0){
                j++;
            }
            if(rst<j-i){
                rst = j-i;
            }
            i=j;
        }
        return rst+1;
    }
    public static int[] getM(int[] a,int n){
        max = a[0];
        min = a[0];
        for(int i=1; i<n; i++){
            if(max<a[i]){
                max=a[i];
            }
            if(min>a[i]){
                min=a[i];
            }
        }
        return new int[max-min+1];
    }
}