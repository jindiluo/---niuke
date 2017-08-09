package 公共子串计算;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNext()){
			String str1=scanner.nextLine();
			String str2=scanner.nextLine();
			System.out.println(comline(str1,str2));
		}
	}

	private static int comline(String str1, String str2) {
		// TODO Auto-generated method stub
		int n=str1.length();
		int m=str2.length();
		int[][] dp=new int[n+1][m+1];
		int max=0;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			if(str1.charAt(i-1)==str2.charAt(j-1)){
				dp[i][j]=dp[i-1][j-1]+1;
			}else{
				dp[i][j]=0;
			}
			max=Math.max(dp[i][j], max);
		}
		
	}
		return max;
	}

}
