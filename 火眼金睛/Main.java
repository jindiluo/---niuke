/**
 *
 */
/**
 * @author Administrator
 *
 */
package 火眼金睛;




import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            // 建立有向连接图比较合适这个问题。1->2 表示 2回答了1的问题 2->1表示1回答了2的问题
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
        boolean[] isCheak = new boolean[n + 1];// 来判断每个id是否作弊
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (j != i && map[i][j] == 1 && map[j][i] == 1) { // i 和 j 都作弊
                                                        // (A回答了B的问题，同时B回答了A的问题)
                    isCheak[i] = true;
                    isCheak[j] = true;
                }
                // 还有一种作弊情况：作弊ID用户A和作弊ID用户B同时回答了C的问题
                if (j != i && map[i][j] == 1 && isCheak[j]) { // 统计有多少作弊用户答了i用户提的问题
                    count++;
                }
            }
            if (count >= 2) { // 如果超过两个作弊用户答了i用户提的问题
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
                    //System.out.println(i + " ");  这样输出不行  试了10几次  心都碎了
                    System.out.print(" ");
                }
                else{
                    System.out.println();
                }
            }
        }
    }
}