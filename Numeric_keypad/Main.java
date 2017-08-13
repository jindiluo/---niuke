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
    // ������������򣬷��������λ��
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
        digit = digit > 0 ? --digit : 10;// �����0������Ϊ�����ڵ�λ����10�������Ķ�������-1,
        x = digit / 3; // ����
        y = digit % 3; // ����
        return new Point(x, y);
    }
    /**
     * ���ַ������int����
     * @param numString �ַ���
     * @return ����int����
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
     * ��int�������ַ������
     * @param numArray int����
     * @return �����ַ���
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
     * �������⣬����ֻ�����ң������ߡ� ��ˣ���һ�������ڼ��̾����е�λ������(x1,y1),�ڶ��������ڼ��̾����е�λ������(x2,y2)
     * ��Ҫ����x1<=x2&&y1<=y2;
     * 
     * @param x
     *            �����ϵ�����1
     * @param y
     *            �����ϵ�����2
     * @return ������Ե������true����֮������false
     */
    static boolean reach(int x, int y) // �ж�x�ܷ񵽴�y
    {
        Point pointX = locate(x); // ��ȡx���� ��
        Point pointY = locate(y); // ��ȡy���� ��
        return pointX.x <= pointY.x && pointX.y <= pointY.y;
    }
 
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        List<String> list = new ArrayList<String>();
        for (; T-- > 0;) {
            int[] indexNum = stringToIntArray(scanner.next());
             
            for (int i = 0; i < indexNum.length - 1; i++) // ��Ϊ������i+1���������ﲻ��<length
            {
                // �����i���������ҵ�����λ�ϵ������ܹ����ӵ�i+1λ�ϵ����֣�������ж�i+1��i+2�Ƿ�ɴ������ɴ���ֱ�����
                while (!reach(indexNum[i], indexNum[i + 1])) {
                    if (--indexNum[i + 1] < 0)
                        indexNum[i--]--;
                    for (int j = i + 2; j < indexNum.length; j++)
                        indexNum[j] = 9;
                    //����i=-1�����
                    if(i==-1)
                        i=0;
                }
            }
            //��ӵ�list�У����д�ӡ
            list.add(intArrayToString(indexNum));
        }
        scanner.close();
        for (String string : list) {
            System.out.println(string);
        }
    }
 
    //���Ի�ȡ����9��λ��
   
    public void testLocate() {
        System.out.println(locate(9));
    }
 
    //�������������ǲ��ǿ��Ե���
   
    public void testReach() {
        System.out.println(reach(8, 9));
    }
     
    //char��int��ת
  
    public void testCharToInt() {
        System.out.println(Integer.parseInt('9' + ""));
        System.out.println(String.valueOf(9).charAt(0));
    }
 
}
//������
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