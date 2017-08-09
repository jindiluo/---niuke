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
        //得到一个26以内的fibonacci的数组
        int[] fib= getFib(26);
        ArrayList<String> luckys = new ArrayList<>();//保存lucky子串

        Scanner in = new Scanner(System.in);
        String str = in.next();

        //获取所有不重复的子串
        Set<String> allSubStr= new HashSet<>();
        for(int i=0;i<str.length();i++){
            for(int j= i;j<str.length();j++){
                allSubStr.add(str.substring(i,j+1));
            }
        }

        //字典排序所有子串
        ArrayList<String> subList=new ArrayList<>();
        subList.addAll(allSubStr);
        Collections.sort(subList);

        //统计每个子串的不同字符数
        for(String item:subList){
            int[] flag = new int[26];
            int characters=0;
            for(int i=0;i<item.length();i++){
                flag[item.charAt(i)-'a'] = 1;
            }
            //统计flag中1的个数
            for(int j=0;j<26;j++){
                if(flag[j]==1) characters++;
            }

            //如果characters在fib数组中，那么这个item是lucky子串 ，输出，同时保存
            if(contains(fib,characters)){
                luckys.add(item);
                System.out.println(item);
            }
        }


    }


    //返回一个fibonacci数组 n是数组大小
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

    //检查数组是否包含目标值
    public static boolean contains(int[] src,int target){
        for(int i:src){
            if(i == target) return true;
        }
        return false;
    }
}