/**
 *
 */
/**
 * @author Administrator
 *
 */
package ��λ������;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i <= n; i ++ )
                list.add(i);
            while (list.size() != 1) {
                // ��0��ʼlist�Ƴ�һ��,i�ټ�һ��,iʼ��ָ������λ
                for (int i = 0; i < list.size(); i = i + 1)
                    list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}