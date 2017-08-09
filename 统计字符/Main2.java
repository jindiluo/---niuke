package Í³¼Æ×Ö·û;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.print(count(input));
        }

        scanner.close();
    }

    private static String count(String s) {
        int[] result = new int[4];

        for (int i = 0; i < s.length(); i++) {
            String c=s.substring(i, i+1);
            if(c.matches("[a-zA-Z]")){
             result[0]++;
            }
            else if(c.matches("[0-9]")){
            	result[1]++;
            }
            else if(c.matches(" ")){
            	result[2]++;
            }
            else {
            	result[3]++;
            }
            
        }
        StringBuilder builder = new StringBuilder();
        for (int i : result) {
            builder.append(i).append('\n');
        }

        return builder.toString(); 
   
        
    }
	

}
