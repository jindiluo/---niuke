/**
 *
 */
/**
 * @author Administrator
 *
 */
package ֽ�Ʋ���;



public class Cards {
    public int cardGame(int[] arr, int n) {
        //f[i][j]��ʾ����ѡ�������[i...j]�ܻ�õķ���
        //s[i][j]��ʾ�Һ�ѡ�������[i...j]�ܻ�õķ���
        int[][] f=new int[n][n];
        int[][] s=new int[n][n];
        for (int j = 0; j < n; j++) {
            //��ѡ�õ��ķ���f[i][i]��Ϊarr[i],�˴�������s[i][i]=0,����Ĭ��ֵ�����㣬���Կ���ʡ��
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][n-1],s[0][n-1]);
    }
}