package ×ÔÊØÊý;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(calcAutomorphicNumbers(n));
        }

        scanner.close();
    }

	private static boolean calcAutomorphicNumbers(int n) {
		// TODO Auto-generated method stub
		while(n!=0){
		if(n%10==7){
			n=n/10;
			return true;
		}
		return false;
		}
		return false;
	}
}
