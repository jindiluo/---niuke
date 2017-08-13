/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最长公共子串;


//第一次做这个题，不过看思路懂了。自己也做出来了
/*
  0 1 2 3 4 5 j
i0
1
2
3
4
i=j=0时，dp[i][j]=0
A[i]=B[j]时(从1计数)，dp[i][j]=dp[i-1][j-1]+1
A[i]!=B[j]时，dp[i][j]=max(dp[i][j-1],dp[i-1][j])
*/

public class LCS {
  public int findLCS(String A, int n, String B, int m) {
      // 行对应A，比A长1，原因是0作为初始化。列同理。dp[n][m]指A[n-1],B[m-1]
      int[][] dp = new int[n+1][m+1];
      for(int i=0;i<dp.length;i++){
          dp[i][0]=0;
      }
      for(int i=0;i<dp[0].length;i++){
          dp[0][i]=0;
      }
      //事实上，数组默认也是0
      for(int i=1;i<dp.length;i++){
          for(int j=1;j<dp[0].length;j++){
              //如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
              if(A.charAt(i-1)==B.charAt(j-1)){//A[0]==B[0],对应dp[1][1]
                  dp[i][j]=dp[i-1][j-1]+1;
              }else{
                  dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
              }
          }
      }
      return dp[n][m];
  }
}