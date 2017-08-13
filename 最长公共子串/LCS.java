/**
 *
 */
/**
 * @author Administrator
 *
 */
package ������Ӵ�;


//��һ��������⣬������˼·���ˡ��Լ�Ҳ��������
/*
  0 1 2 3 4 5 j
i0
1
2
3
4
i=j=0ʱ��dp[i][j]=0
A[i]=B[j]ʱ(��1����)��dp[i][j]=dp[i-1][j-1]+1
A[i]!=B[j]ʱ��dp[i][j]=max(dp[i][j-1],dp[i-1][j])
*/

public class LCS {
  public int findLCS(String A, int n, String B, int m) {
      // �ж�ӦA����A��1��ԭ����0��Ϊ��ʼ������ͬ��dp[n][m]ָA[n-1],B[m-1]
      int[][] dp = new int[n+1][m+1];
      for(int i=0;i<dp.length;i++){
          dp[i][0]=0;
      }
      for(int i=0;i<dp[0].length;i++){
          dp[0][i]=0;
      }
      //��ʵ�ϣ�����Ĭ��Ҳ��0
      for(int i=1;i<dp.length;i++){
          for(int j=1;j<dp[0].length;j++){
              //������ַ�������equals������charAt()���ַ����������㣬�ʿ�����==
              if(A.charAt(i-1)==B.charAt(j-1)){//A[0]==B[0],��Ӧdp[1][1]
                  dp[i][j]=dp[i-1][j-1]+1;
              }else{
                  dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
              }
          }
      }
      return dp[n][m];
  }
}