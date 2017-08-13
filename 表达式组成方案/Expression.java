/**
 *
 */
/**
 * @author Administrator
 *
 */
package 表达式组成方案;


//这题切记要对每一步计算加上取余数的操作 % 10007，否则过不了。
// 思路：构造三维dp矩阵
// dp[i][j][z]，表示从i到j计算结果为z的所有方法总和，这里z的取值只有0和1两种。
//构造dp[i][j][z]的方法为对dp[i][k][z]*dp[k+1][j][z]求和，k取值范围从i到j-1
//。从矩阵的对角线开始，向右上方计算，和矩阵连乘求乘法次数最少的加括号方式类似。

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

