/**
 *
 */
/**
 * @author Administrator
 *
 */
package 发奖金;
//从头到尾，从尾到头都来一遍，结果分别存在两个数组里，最后取两个数组中米一个元素较大的一个，相加得到最后结果。

import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
          int N = scanner.nextInt();
          int[] grades = new int[N];
          for (int i = 0; i < N; i++) {
              grades[i] = scanner.nextInt();
          }

          int[] bonus = new int[N];
          int[] cobonus = new int[N];
          bonus[0] = 1;
          cobonus[N-1] = 1;
          for (int i = 1; i < grades.length; i++) {
              if (grades[i] > grades[i-1])
                  bonus[i] = bonus[i-1] + 1;
              else
                  bonus[i] = 1;
          }
          for (int i = N-1; i > 0; i--) {
              if (grades[i-1] > grades[i])
                  cobonus[i-1] = cobonus[i] + 1;
              else
                  cobonus[i-1] = 1;
          }

          int sum = 0;
          for (int i = 0; i < N; i++) {
              int temp = bonus[i]>cobonus[i]?bonus[i]:cobonus[i];
              sum += temp;
          }
          System.out.println(sum);
      }
  }
}