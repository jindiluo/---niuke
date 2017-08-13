/**
 *
 */
/**
 * @author Administrator
 *
 */
package √‘ŒÌ;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int n=cin.nextInt();
            cin.nextLine();
            String s=cin.nextLine();
            boolean[] find=new boolean[n+1];
            int carryLen=String.valueOf(n).length();
            ArrayList<Integer> arraylist=new ArrayList<>();
            dfs(n,0,find,carryLen,s,arraylist);

        }
    }



    public static void dfs(int n,int start,boolean[] find,int carryLen,String s,ArrayList<Integer> arraylist){

        if(start==s.length()){
            for(int tmp:arraylist)
                System.out.print(tmp+" ");
            System.out.println();
            return ;
        }

        for(int i=1;i<=carryLen;i++){
            if(start+i<=s.length()){
                int num=Integer.parseInt(s.substring(start, start+i));
                if(num<=n&&!find[num]){
                    find[num]=true;
                    arraylist.add(num);
                    dfs(n,start+i,find,carryLen,s,arraylist);
                    arraylist.remove(arraylist.size()-1);
                    find[num]=false;
                }
            }
        }
    }

}