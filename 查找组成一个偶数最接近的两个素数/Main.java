package 查找组成一个偶数最接近的两个素数;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner scanner =new Scanner(System.in);
		while(scanner.hasNext()){
			int input=scanner.nextInt();
			int[] r=new int[2];
			r=getsushu(input);
			System.out.println(r[0]);
			System.out.println(r[1]);
		}
	}

	private static int[] getsushu(int input) {
		int[] r=new int[2];
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<input;i++){
			
			
			if(issushu(i)&&issushu(input-i)){
				
				map.put(i, input-i);
				
			}
		
		
			
		}
		int min=Integer.MAX_VALUE;
		int tmp = 0;
		for(Entry<Integer,Integer> vo : map.entrySet()){ 
          int value=(int)( Math.abs(vo.getValue()- vo.getKey())); 
         // System.out.println(value);
         
           if(value<min){
            	min=value;
            	tmp=vo.getKey();
            }
           
         
		
            }
		// System.out.println(min);
		// System.out.println(tmp);
		r[0]=tmp;
		r[1]=(int)(tmp+min);
		 
		return r;
		// TODO Auto-generated method stub
		
	}
	private static boolean issushu(int input){
		int n=(int)Math.sqrt(input);
		if(input<2){
			return true;
		}
		
		for(int i=2;i<=n;i++){
			if(input%i==0){
				return false;
			}
		}
		
		return true;
		
	}

}
