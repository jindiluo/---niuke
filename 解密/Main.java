/**
 *
 */
/**
 * @author Administrator
 *
 */
package 解密;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String[] a = in.next().split("");
            List<String> list = get(a,a.length);
            Set<String> set = new TreeSet<String>(list);
            for (String string : set) {
                System.out.println(string);
            }
        }
        in.close();
    }

    public static List<String> get(String[] a,int n){
        List<String> list = new ArrayList<String>();
        if(n==1){
            for(int i = 0;i<a.length;i++){
                list.add(a[i]);
            }
            return list;
        }
        List<String> temp = get(a,n-1);
        for(int i = 0;i<a.length;i++){

            for(int j = 0;j<temp.size();j++){
                if(temp.get(j).indexOf(a[i])<0)
                    list.add(a[i]+temp.get(j));
            }
        }

        return list;
    }
}