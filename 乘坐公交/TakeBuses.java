/**
 *
 */
/**
 * @author Administrator
 *
 */
package ³Ë×ø¹«½»;

public class TakeBuses {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int missTime = s%interval[i];
            int waitCost = missTime==0?0:interval[i]-missTime;
            min = Math.min(min,waitCost+(stops[i]+1)*5+stops[i]*period[i]);
        }
        return min+s;
    }
}