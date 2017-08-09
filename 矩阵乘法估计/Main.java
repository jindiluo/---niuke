package 矩阵乘法估计;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int [][] array = new int[num][num];
            for (int i=0; i<num; i++) {
                array[i][0] = scanner.nextInt();
                array[i][1] = scanner.nextInt();
            }
            String rule = scanner.next();
            calculate(num,array,rule);
        }
        scanner.close();
    }

    //整体思想：
    /*int result = 0； 存最终结果
    遇左括号，不做处理
    遇字母N，将N的x,y 入栈，stack.push(x), stack.push(y)
    遇右括号，栈中顶部肯定依次是两个矩阵的z,y,y,x值,弹出（int z  = stack.pop(),int y  = stack.pop(),
    int y  = stack.pop(),int x  = stack.pop()）后 result += x*y*z; 然后将 x,z作为新的矩阵入栈
    (stack.push(x),stack.push(y))
    终止条件：由于执行到最后一个）时，此时表达式为（N）,不能再进行乘法运算，因此终止条件为：string.len()-1
    * */
    private static void calculate(int num, int[][] array, String rule) {
        Stack<Integer> value = new Stack<Integer>();//存储矩阵中行和列
        char [] charrule = rule.toCharArray();
        int index = 0;
        int result = 0;
        for (int i=0; i<charrule.length-1; i++) {//执行到最后一个）是只剩（X）,因此不能循环到最后一个）
            if (charrule[i]=='(')
                continue;
            else if (charrule[i]>='A' && charrule[i]<='Z') {
                value.push(array[index][0]);
                value.push(array[index][1]);
                index++;
            }
            else if (charrule[i]==')') {
                int lasty = value.pop();
                int lastx = value.pop();
                int prey = value.pop();
                int prex = value.pop();
                result += prex * prey * lasty;
                value.push(prex);
                value.push(lasty);
            }
        }
        System.out.println(result);
    }
}