package ×Ö·û´®·Ö¸î;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
        	int n=Integer.parseInt(scanner.nextLine());
  //int n=scanner.nextInt();
        	for(int i=0;i<n;i++){
           String input  = scanner.nextLine();
          stringsplit(input);
        	}
           
        }
        scanner.close();
    }

	private static void stringsplit(String string) {
		// TODO Auto-generated method stub
		int a=string.length()%8;
		StringBuilder builder=new StringBuilder(string);
		if(a!=0){
			for(int i=a;i<8;i++){
				builder.append('0');
			}
			
			
	
		}
		String str=builder.toString();
		for(int i=0;i<str.length();i+=8){
			System.out.println(str.substring(i, i+8));
		}
	
	}

	}
		
		
		

    
    
    
    
    
    

