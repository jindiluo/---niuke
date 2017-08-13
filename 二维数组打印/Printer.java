/**
 *
 */
/**
 * @author Administrator
 *
 */
package 二维数组打印;



public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] result = new int[n * n];
        int row = 0, col = n - 1, index = 0;
        while(row < n) {
            while(row < n && col < n) {
                result[index++] = arr[row][col];
                row++;
                col++;
            }
            if(row < col) {
                col -= row + 1;
                row = 0;
            } else {
                row -= col - 1;
                col = 0;
            }
        }
        return result;
    }
}