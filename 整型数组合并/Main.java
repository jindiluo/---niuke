package 整型数组合并;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class Main {
	 public static void main(String[] args){
		 //利用Treeset直接能够得到答案
		 Scanner scanner =new Scanner(System.in);
		 int n=scanner.nextInt();
		Set<Integer> n1=new HashSet<Integer>();
		for(int i=0;i<n;i++){
			n1.add(scanner.nextInt());
		}
		int m=scanner.nextInt();
		for(int i=0;i<m;i++){
			n1.add(scanner.nextInt());
		}
		int[] a=new int[n1.size()];
		int j=0;
			Iterator<Integer> it =n1.iterator();
			while(it.hasNext()){
				a[j]=(int) it.next();
			
				j++;
			}
		
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++){
		
			System.out.print(a[i]);
			
		}
	 }

}
