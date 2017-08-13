/**
 *
 */
/**
 * @author Administrator
 *
 */
package ì³²¨À­Æõ¼ÓÇ¿°æ;



public class Fibonacci {
    public int getNthNumber(int n) {
        // write code here
        long[][] base={{1,1},{1,0}};
        long[][] ret={{1,0},{0,1}};
        while(n!=0){
            if(n%2==1)
                ret=MultMetri(ret,base);
            base=MultMetri(base,base);
            n=n>>1;
        }
        return (int)(ret[0][0]);
}
     public static long[][] MultMetri(long[][] ret,long[][] base){
        long[][] tmp=new long[2][2];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                tmp[i][j]=(ret[i][0]*base[0][j]+ret[i][1]*base[1][j])%1000000007;
        for(int k=0;k<2;k++)
            for(int q=0;q<2;q++)
                ret[k][q]=tmp[k][q];
       return ret;
    }
}