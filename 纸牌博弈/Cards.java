/**
 *
 */
/**
 * @author Administrator
 *
 */
package 纸牌博弈;



public class Cards {
    public int cardGame(int[] arr, int n) {
        //f[i][j]表示我先选的情况下[i...j]能获得的分数
        //s[i][j]表示我后选的情况下[i...j]能获得的分数
        int[][] f=new int[n][n];
        int[][] s=new int[n][n];
        for (int j = 0; j < n; j++) {
            //先选得到的分数f[i][i]即为arr[i],此处隐藏了s[i][i]=0,由于默认值就是零，所以可以省略
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][n-1],s[0][n-1]);
    }
}