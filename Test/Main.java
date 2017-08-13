/**
 *
 */
/**
 * @author Administrator
 *
 */
package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] s= new int[n];
            for(int i=0;i<n;i++){
            	s[i]=i+1;


            }
            System.out.println(num(n,k,s));

        }
        scanner.close();
    }

	private static int num( int n,int k,int[] s) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result=null;
		result=subsetsWithDup(s);


		int count=0;
		 ArrayList<Integer> tmp=null;
   for(int j=0;j<result.size();j++){

          tmp=result.get(j);


			if(tmp.size()==n){
				if(check1(tmp,k)&&check2(tmp,k)){
					count++;
				}


			}
   }



        count=count%1000000007;
		return count+n;
	}


		public static Boolean check1(ArrayList<Integer> tmp,int k){
			for(int i=0;i<tmp.size();i++){
				if(tmp.get(i)<1||tmp.get(i)>k)
				{return false;}
			}
			return true;

		}
		public static Boolean check2(ArrayList<Integer> tmp,int k){
			for(int i=0;i<tmp.size();i++){
				if(tmp.get(i)<=tmp.get(i+1)||(tmp.get(i)%tmp.get(i+1))!=0)
				{return true;}
			}
			return false;

		}

		public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(num);
			res.add(tmp);
			dfs(res, tmp, num, 0);
			return res;
		}

		public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int pos) {
			for (int i = pos; i <= num.length - 1; i++) {
				tmp.add(num[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, num, i + 1);
				tmp.remove(tmp.size() - 1);
				while (i < num.length - 1 && num[i] == num[i + 1])
					i++; // 唯一的区别就在这一行
			}
		}
}
