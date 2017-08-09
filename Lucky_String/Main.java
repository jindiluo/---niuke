/**
 *
 */
/**
 * @author Administrator
 *
 */
package Lucky_String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //�õ�һ��26���ڵ�fibonacci������
        int[] fib= getFib(26);
        ArrayList<String> luckys = new ArrayList<>();//����lucky�Ӵ�

        Scanner in = new Scanner(System.in);
        String str = in.next();

        //��ȡ���в��ظ����Ӵ�
        Set<String> allSubStr= new HashSet<>();
        for(int i=0;i<str.length();i++){
            for(int j= i;j<str.length();j++){
                allSubStr.add(str.substring(i,j+1));
            }
        }

        //�ֵ����������Ӵ�
        ArrayList<String> subList=new ArrayList<>();
        subList.addAll(allSubStr);
        Collections.sort(subList);

        //ͳ��ÿ���Ӵ��Ĳ�ͬ�ַ���
        for(String item:subList){
            int[] flag = new int[26];
            int characters=0;
            for(int i=0;i<item.length();i++){
                flag[item.charAt(i)-'a'] = 1;
            }
            //ͳ��flag��1�ĸ���
            for(int j=0;j<26;j++){
                if(flag[j]==1) characters++;
            }

            //���characters��fib�����У���ô���item��lucky�Ӵ� �������ͬʱ����
            if(contains(fib,characters)){
                luckys.add(item);
                System.out.println(item);
            }
        }


    }


    //����һ��fibonacci���� n�������С
    public static int[] getFib(int n){
        int[] res= new int[n];
        res[0]=1;
        res[1]=1;

        if(n==1||n==2) return res;
        int i= 2;
        while(i++<n-1){
            res[i] = res[i-1]+res[i-2];
        }
        return res;
    }

    //��������Ƿ����Ŀ��ֵ
    public static boolean contains(int[] src,int target){
        for(int i:src){
            if(i == target) return true;
        }
        return false;
    }
}