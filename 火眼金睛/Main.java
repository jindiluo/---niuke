/**
 *
 */
/**
 * @author Administrator
 *
 */
package ���۽�;




import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            // ������������ͼ�ȽϺ���������⡣1->2 ��ʾ 2�ش���1������ 2->1��ʾ1�ش���2������
            int[][] map = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                int id = scanner.nextInt();
                int ansNum = scanner.nextInt();
                int[] ids = new int[ansNum];
                for (int j = 0; j < ansNum; j++) {
                    ids[j] = scanner.nextInt();
                    map[id][ids[j]] = 1;
                }
            }
            cheatNum(n, map);
        }
    }

    public static void cheatNum(int n, int[][] map) {
        int cheatNum = 0;
        boolean[] isCheak = new boolean[n + 1];// ���ж�ÿ��id�Ƿ�����
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (j != i && map[i][j] == 1 && map[j][i] == 1) { // i �� j ������
                                                        // (A�ش���B�����⣬ͬʱB�ش���A������)
                    isCheak[i] = true;
                    isCheak[j] = true;
                }
                // ����һ���������������ID�û�A������ID�û�Bͬʱ�ش���C������
                if (j != i && map[i][j] == 1 && isCheak[j]) { // ͳ���ж��������û�����i�û��������
                    count++;
                }
            }
            if (count >= 2) { // ����������������û�����i�û��������
                isCheak[i] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (isCheak[i]) {
                cheatNum++;
            }
        }
        System.out.println(cheatNum);
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            if (isCheak[i]) {
                temp++;
                System.out.print(i);
                if(temp != cheatNum){
                    //System.out.println(i + " ");  �����������  ����10����  �Ķ�����
                    System.out.print(" ");
                }
                else{
                    System.out.println();
                }
            }
        }
    }
}