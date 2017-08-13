/**
 *
 */
/**
 * @author Administrator
 *
 */
package ���ʽ��ɷ���;


//�����м�Ҫ��ÿһ���������ȡ�����Ĳ��� % 10007����������ˡ�
// ˼·��������άdp����
// dp[i][j][z]����ʾ��i��j������Ϊz�����з����ܺͣ�����z��ȡֵֻ��0��1���֡�
//����dp[i][j][z]�ķ���Ϊ��dp[i][k][z]*dp[k+1][j][z]��ͣ�kȡֵ��Χ��i��j-1
//���Ӿ���ĶԽ��߿�ʼ�������Ϸ����㣬�;���������˷��������ٵļ����ŷ�ʽ���ơ�

public class Expression {
  public int cal(int d1, int d2, char op) {

      if (op == '&') {
          return d1 & d2;
      } else if (op == '|') {
          return d1 | d2;
      } else {
          return d1 ^ d2;
      }
  }

  public int count(int[] digits, char[] ops, int des) {

      int n = digits.length;

      int[][][] dp = new int[n][n][2];

      for (int i = 0; i < n; ++i) {
          if (digits[i] == 1) {
              ++dp[i][i][1];
          } else {
              ++dp[i][i][0];
          }
      }

      for (int x = 1; x < digits.length; ++x) {
          for (int i = 0; i < digits.length - x; ++i) {
              int j = i + 1 + x - 1;
              for (int k = i; k < j; ++k) {
                  if (dp[i][k][0] != 0 && dp[k + 1][j][0] != 0) {
                      int num = cal(0, 0, ops[k]);
                      dp[i][j][num] = (dp[i][j][num] + dp[i][k][0] * dp[k + 1][j][0]) % 10007;
                  }
                  if (dp[i][k][0] != 0 && dp[k + 1][j][1] != 0) {
                      int num = cal(0, 1, ops[k]);
                      dp[i][j][num] = (dp[i][j][num] + dp[i][k][0] * dp[k + 1][j][1]) % 10007;
                  }
                  if (dp[i][k][1] != 0 && dp[k + 1][j][0] != 0) {
                      int num = cal(1, 0, ops[k]);
                      dp[i][j][num] = (dp[i][j][num] + dp[i][k][1] * dp[k + 1][j][0]) % 10007;
                  }
                  if (dp[i][k][1] != 0 && dp[k + 1][j][1] != 0) {
                      int num = cal(1, 1, ops[k]);
                      dp[i][j][num] = (dp[i][j][num] + dp[i][k][1] * dp[k + 1][j][1]) % 10007;
                  }
              }
          }
      }

      return dp[0][n - 1][des];
  }

  public int countWays(String exp, int len, int ret) {
      // write code here
      char[] exps = exp.toCharArray();
      int[] digits = new int[(exps.length + 1) / 2];
      char[] ops = new char[(exps.length - 1) / 2];
      for (int i = 0; i < exps.length; ++i) {
          if (i % 2 == 0) {
              digits[i / 2] = Integer.valueOf(exps[i] - '0');
          } else {
              ops[i / 2] = exps[i];
          }
      }
      return count(digits, ops, ret) % 10007;
  }
}

