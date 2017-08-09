package 记录负数求正数均值;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        int countfu=0;
		int sum=0;
		int countzheng=0;
        while (scanner.hasNext()) {
        	int n=scanner.nextInt();
        	
    		
    			if(n<0){
    				countfu++;
    			}
    			else{
    				countzheng++;
    				sum+=n;
    				
    			}
    		
    		
    		
    		
        }
        System.out.println(countfu);
		if(countzheng==0.0){System.out.println(0.0);}
		else{
		System.out.println( System.out.printf("%.1f",(float)sum/countzheng));}
        scanner.close();
    }

	
}
