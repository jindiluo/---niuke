package �ַ���������_�����ȡ;

import java.util.Scanner;
//˼·����һ���ַ������䱾���ַ��������Ĺ����Ӵ�

public class Main2 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        //String strrev = new StringBuilder(str).reverse().toString();
	        //������ַ����ȽϷ���ķ�ת�������Ժ�����á�
//	        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
	        while (scanner.hasNext()) {
	            String input = scanner.nextLine();
	            System.out.println(longestPalindrome(input));
	        }

	        scanner.close();
	    }

		private static int longestPalindrome(String input) {
			int n=input.length();
			int[][] dp=new int[n+1][n+1];
		char[] c1=input.toCharArray();
		int max=0;
		for(int i=1;i<=n;i++){
			for(int j=n;j>=1;j--){
				//System.out.println(c1[n-j]);
				if(c1[i-1]==c1[n-j]){
					dp[i][j]=dp[i-1][j-1]+1;
					
				}
				else{dp[i][j]=0;}
				max=Math.max(max, dp[i][j]);
			}
			
		}
			return max;
		}


}