/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最长递增子序列;


public class AscentSequence {
    public int findLongest(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }
}