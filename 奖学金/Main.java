/**
 *
 */
/**
 * @author Administrator
 *
 */
package ½±Ñ§½ð;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Score {
        int a;
        int b;
        int current;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
            this.current = a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Score> priorityQueue = null;
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            int full = scanner.nextInt();
            int avg = scanner.nextInt();
            int total = n * avg;

            priorityQueue = new PriorityQueue<Score>(n, new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    if (o1.b == o2.b)
                        return 0;
                    else if (o1.b > o2.b)
                        return 1;
                    else
                        return -1;
                }
            });

            for (int i = 0; i < n; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                total -= a;
                Score score = new Score(a, b);
                priorityQueue.add(score);
            }
            long needTime = 0;
            while (!priorityQueue.isEmpty() && total > 0) {
                Score score = priorityQueue.remove();

                int tmp = full - score.a;
                if (total < tmp) {
                    tmp = total;

                }
                score.current = full;
                total -= tmp;
                needTime += tmp * score.b;
            }
            System.out.println(needTime);
        }
        scanner.close();
    }
}