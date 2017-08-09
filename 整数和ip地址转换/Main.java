package 整数和ip地址转换;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		    
	        Scanner scanner = new Scanner(System.in);
//	        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
	        while (scanner.hasNext()) {
	            String input = scanner.nextLine();
	            System.out.println(convert(input));
	        }

	        scanner.close();
	        
	    }
	 private static String convert(String input){
		 String[] str=input.split("\\.");
		 StringBuilder result=new StringBuilder();
		 for(int i=0;i<str.length;i++){
			 int index=Integer.parseInt(str[i]);
			 StringBuilder sb=new StringBuilder();
			 String tmp=Integer.toBinaryString(index);
			 for(int j=tmp.length();j<8;j++){
				 sb.append('0');
			 }
			 sb.append(tmp);
			
			result.append(sb.toString());
		 }
		
		 String c= Integer.valueOf(result.toString(),2).toString(); 
		 return c;
	 }

}
