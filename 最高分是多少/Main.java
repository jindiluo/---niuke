/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最高分是多少;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        while(console.hasNext()) {

            // 输入数据

            String[] nm = console.nextLine().split(" ");

            int n = Integer.valueOf(nm[0]);

            int m = Integer.valueOf(nm[1]);



            String[] scoreStr = console.nextLine().split(" ");

            int[] score = new int[n];

            for(int i = 0; i < n; i++) {

                score[i] = Integer.valueOf(scoreStr[i]);

            }



            String[] play = new String[m];

            for(int i = 0; i < m; i++) {

                play[i] = console.nextLine();

            }



            for(int i = 0; i < m; i++) {

                String[] updateStr = play[i].split(" ");

                int temp1 = Integer.valueOf(updateStr[1]); // 读入第一个数字

                int temp2 = Integer.valueOf(updateStr[2]); // 读入第二个数字

                if(updateStr[0].equals("Q")) {

                    int maxScore = findMax(score, temp1 - 1, temp2 - 1);

                    System.out.println(maxScore);

                }

                if(updateStr[0].equals("U")) {

                    score[temp1 - 1] = temp2;

                }

            }

        }

        console.close();

    }



    private static int findMax(int[] score, int v, int w) {

        int max = score[v];

        if(v < w) {

            for(int i = v; i <= w; i++) {

                if(score[i] > max)

                    max = score[i];

            }

        }else{

            for(int i = v; i >= w; i--) {

                if(score[i] > max)

                    max = score[i];

            }

        }

        return max;

    }

}