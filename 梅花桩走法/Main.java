package ÷��׮�߷�;

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
        // �Ե�a1ΪĩԪ�ص�����������г���Ϊ1��
        f[0] = 1;
        int max=1;
        for (int i = 1; i < n; i++) {// ѭ��n-1��
            // f[i]����СֵΪ1��
            f[i] = 1;
           
            for (int j = 0; j < i; j++) {// ѭ��i��
                if (a[j] < a[i]) {
                    // ����f[i]��ֵ��
                    f[i]=Math.max(f[i],f[j]+1);
                }
                max=Math.max(f[i],max);
            }
        }
        // ����㷨������ѭ�������ѭ������Ϊn-1�Σ��ڲ�ѭ������Ϊi�Σ�
        // �㷨��ʱ�临�Ӷ�����T(n)=O(n2)��
		return max;
        
    }



}
