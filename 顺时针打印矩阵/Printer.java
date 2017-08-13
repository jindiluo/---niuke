/**
 *
 */
/**
 * @author Administrator
 *
 */
package ˳ʱ���ӡ����;


public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {

        // write code here
        int startX = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        int index = 0;
        int[] result = new int[n * m];

        while (startX <= endX && startY <= endY) {

            // �����Ҵ�ӡ
            if(startX <= endX){
                for (int i = startX; i <= endX; i++) {
                    result[index++] = mat[startY][i];
                }
            }


            // �������´�ӡ

            if (startY < endY) {

                for (int i = startY + 1; i <= endY; i++) {
                    result[index++] = mat[i][endX];
                }
            }

            // ���������ӡ
            if (startX < endX && endY > startY) {
                for (int i = endX - 1; i >= startX; i--) {
                    result[index++] = mat[endY][i];
                }
            }

            // �������ϴ�ӡ
            if (startY < endY && endX > startX) {
                for (int i = endY - 1; i >= startY + 1; i--) {
                    result[index++] = mat[i][startX];
                }
            }

            startX++;
            endX--;
            startY++;
            endY--;
        }
        return result;


    }
}
