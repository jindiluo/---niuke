/**
 * 
 */
/**
 * @author Administrator
 *
 */
package �˿��ƴ�С;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] left,right;
        String[] line;
        String nextLine,outString;
        while(sc.hasNext()){
            nextLine = sc.nextLine();
            //����ը����ը���
            if(nextLine.contains("joker JOKER")){
                outString = "joker JOKER";
            }else{
                //��� �Ȳ������ �ٲ�ɵ���
                line = nextLine.split("-");
                left = line[0].split(" ");
                right = line[1].split(" "); 
                 
                //ը�����
                if(left.length == 4 && right.length != 4){
                    outString = line[0];
                }else if(right.length == 4 && left.length != 4){
                    outString = line[1];
                }
                // ������ͬ������±Ƚ���С���ƵĴ�С��compare��������������Ӧ��ֵ
                else if(right.length == left.length){               
                    if(count(left[0])>count(right[0])){
                        outString = line[0];
                    }
                    else{
                        outString = line[1];
                    }       
                }else{
                    outString = "ERROR";
                }
            }
             
            System.out.println(outString);
 
        }
    }
 
    //2-JOKER ����С����2-16
    private static int count(String str) {
        return "345678910JQKA2jokerJOKER".indexOf(str);}}