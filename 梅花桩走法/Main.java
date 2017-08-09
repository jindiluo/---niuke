package 梅花桩走法;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	    
	      while (scanner.hasNext()) {

	          int n = scanner.nextInt();
	        int[] arr=new int[n];
	        for(int i=0;i<n;i++){
	        	arr[i]=scanner.nextInt();
	        }
	         System.out.println(getlong(arr,n));
	      }

	      scanner.close();
	  }

	private static int getlong(int[] a,int n) {
       
        int[] f = new int[n];
        // 以第a1为末元素的最长递增子序列长度为1；
        f[0] = 1;
        int max=1;
        for (int i = 1; i < n; i++) {// 循环n-1次
            // f[i]的最小值为1；
            f[i] = 1;
           
            for (int j = 0; j < i; j++) {// 循环i次
                if (a[j] < a[i]) {
                    // 更新f[i]的值。
                    f[i]=Math.max(f[i],f[j]+1);
                }
                max=Math.max(f[i],max);
            }
        }
        // 这个算法有两层循环，外层循环次数为n-1次，内层循环次数为i次，
        // 算法的时间复杂度所以T(n)=O(n2)。
		return max;
        
    }



}
