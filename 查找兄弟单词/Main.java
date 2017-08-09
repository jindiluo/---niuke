package 查找兄弟单词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Scanner scanner=new Scanner(System.in);
           while(scanner.hasNext()){
        	   int n=scanner.nextInt();
        	   ArrayList<String> list=new ArrayList<String>();
        	   for(int i=0;i<n;i++){
        		   list.add(scanner.next());

        	   }
        	   String key=scanner.next();
        	   char[] keyarr=key.toCharArray();
        	   Arrays.sort(keyarr);
        	   int weizhi=scanner.nextInt();
        	 search(list,keyarr,key,weizhi);
           }
	}

	private static void search(ArrayList<String> list, char[] keyarr,String key,int weizhi) {
		// TODO Auto-generated method stub
		ArrayList<String> out= new ArrayList<String>();
		int count=0;
		for(int i=0;i<list.size();i++){
			int c=check(list.get(i),keyarr,key);
			//System.out.println(c);
			count+=c;
			if(c==1){
				out.add(list.get(i));


			}
		}
		System.out.println(count);
		Collections.sort(out);
        if(count>=weizhi){
        	System.out.println(out.get(weizhi-1));
        	//这里输出的是位置    注意！！！！！！！！！！！！！
        }

	}

	private static int check(String string, char[] keyarr,String key) {
		// TODO Auto-generated method stub
		if(string.equals(key)||string.length()!=keyarr.length){
			return 0;
		}
		char[] stringarr=string.toCharArray();
	   Arrays.sort(stringarr);
		/*for(int i=0;i<key.length();i++){
			if(stringarr[i]!=keyarr[i]){
				return 0;

			}
		}*/
		//return 1;
		Arrays.equals(stringarr,keyarr);
		if(Arrays.equals(stringarr,keyarr)){return 1;}
		else{return 0;}

	}

}
