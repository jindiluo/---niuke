
package 根据标识来排序;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
    
      while (scanner.hasNext()) {

          int n = scanner.nextInt();
         ArrayList<Integer> list=new ArrayList<Integer>();
      for(int i=0;i<n;i++){
    	 list.add(scanner.nextInt());
      }
      int flag=scanner.nextInt();
      sortIntegerArray(list,flag);
         
      }

      scanner.close();
  }

	
	private static void sortIntegerArray(ArrayList<Integer> list, int flag) {
		// TODO Auto-generated method stub
		
		if(flag==0){
			Collections.sort(list);
			 

for(int i=0;i<list.size();i++){
if( i==list.size()-1){
System.out.print(list.get(i));}
else{
System.out.print(list.get(i)+" ");
}}}





		else if(flag==1){
	Collections.sort(list);
	 

for(int i=0;i<list.size();i++){
if( i==list.size()-1){
System.out.print(list.get(list.size()-1-i));}
else{
System.out.print(list.get(list.size()-1-i)+" ");
}}
}
	
		}
	}


	

