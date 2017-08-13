/**
 * 
 */
/**
 * @author Administrator
 *
 */
package Numeric_keypad;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 

 
 
public class Main {
    // 按照下面的排序，返回数组的位置
    /**
     * 1 2 3 
     * 4 5 6 
     * 7 8 9 
     *   0
     * 
     * @param digit
     * @return
     */
    static Point locate(int digit) {
        int x = 0, y = 0;
        digit = digit > 0 ? --digit : 10;// 如果是0，则认为其所在的位置是10，其他的都是数字-1,
        x = digit / 3; // 行数
        y = digit % 3; // 列数
        return new Point(x, y);
    }
    /**
     * 将字符串变成int数组
     * @param numString 字符串
     * @return 返回int数组
     */
    public static int[] stringToIntArray(String numString)
    {
        int [] ret = new int[numString.length()];
        for (int i = 0; i < numString.toCharArray().length; i++) {
            ret[i] = Integer.parseInt(numString.toCharArray()[i]+"");
        }
        return ret;
    }
     
    /**
     * 将int数组编程字符串输出
     * @param numArray int数组
     * @return 返回字符串
     */
    public static String intArrayToString(int [] numArray)
    {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numArray.length; i++) {
            ret.append(numArray[i]);
        }
        return ret.toString();
    }
     
    /**
     * 根据题意，我们只能向右，向下走。 因此，第一个数字在键盘矩阵中的位置坐标(x1,y1),第二个数字在键盘矩阵中的位置坐标(x2,y2)
     * 需要满足x1<=x2&&y1<=y2;
     * 
     * @param x
     *            键盘上的数字1
     * @param y
     *            键盘上的数组2
     * @return 如果可以到达，返回true，反之，返回false
     */
    static boolean reach(int x, int y) // 判断x能否到达y
    {
        Point pointX = locate(x); // 获取x的行 列
        Point pointY = locate(y); // 获取y的行 列
        return pointX.x <= pointY.x && pointX.y <= pointY.y;
    }
 
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        List<String> list = new ArrayList<String>();
        for (; T-- > 0;) {
            int[] indexNum = stringToIntArray(scanner.next());
             
            for (int i = 0; i < indexNum.length - 1; i++) // 因为后面有i+1操作，这里不能<length
            {
                // 如果第i（从左向右递增）位上的数字能够连接第i+1位上的数字，则继续判断i+1和i+2是否可达，如果都可打，则直接输出
                while (!reach(indexNum[i], indexNum[i + 1])) {
                    if (--indexNum[i + 1] < 0)
                        indexNum[i--]--;
                    for (int j = i + 2; j < indexNum.length; j++)
                        indexNum[j] = 9;
                    //处理i=-1的情况
                    if(i==-1)
                        i=0;
                }
            }
            //添加到list中，集中打印
            list.add(intArrayToString(indexNum));
        }
        scanner.close();
        for (String string : list) {
            System.out.println(string);
        }
    }
 
    //测试获取键盘9的位置
   
    public void testLocate() {
        System.out.println(locate(9));
    }
 
    //测试两个数字是不是可以到达
   
    public void testReach() {
        System.out.println(reach(8, 9));
    }
     
    //char和int互转
  
    public void testCharToInt() {
        System.out.println(Integer.parseInt('9' + ""));
        System.out.println(String.valueOf(9).charAt(0));
    }
 
}
//坐标类
class Point {
    public int x;
    public int y;
 
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public String toString() {
        return "(x,y)=(" + x + "," + y + ")";
    }
}