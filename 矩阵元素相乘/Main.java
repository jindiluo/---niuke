/**
 *
 */
/**
 * @author Administrator
 *
 */
package ¾ØÕóÔªËØÏà³Ë;


import java.util.Scanner;
public class Main{
     public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][m];
            int max = -1;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    a[i][j] = in.nextInt();
                }
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    int r = getMax(a,i,j);
                    if(r>max)
                        max = r;
                }
            }
            System.out.println(max);

        }
    }

    public static int getMax(int[][] a,int I,int J){
        int max = 1;
        for(int i = 0;i<a.length;i++){
            if(i==I)
                continue;
            max *= a[i][J];
        }
        for(int j = 0;j<a[0].length;j++){
            if(j==J)
                continue;
            max *= a[I][j];
        }
        return max;
    }
}