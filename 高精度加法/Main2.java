package 高精度加法;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		
		Scanner in= new Scanner(System.in);
		while(in.hasNext()){
			String a=in.next();
			String b=in.next();
			BigInteger c=new BigInteger(a);
			BigInteger d=new BigInteger(b);
			System.out.print(c.add(d));
			
			
		}
		
		
	}

}
