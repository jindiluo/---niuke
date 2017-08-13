/**
 *
 */
/**
 * @author Administrator
 *
 */
package ÄÌÅ£¼Ò×å;

public class Cows {
    public int countSum(int n) {
        if(n<4)
            return n;
        long[][] res=new long[][]{{3,2,1}};
        long[][] base=new long[][]{{1,1,0},{0,0,1},{1,0,0}};
        n-=3;
        while(n>0){
            if((n&1)>0){
                res=multiply(res,base);
            }
            base=multiply(base,base);
            n=n>>1;
        }
        return (int) res[0][0]%1000000007;
    }
    public long[][] multiply(long[][] a,long[][] b){
        int L1=a.length;
        int L2=a[0].length;
        int L3=b[0].length;
        long[][]  res=new long[L1][L3];
        for(int i=0;i<L1;i++)
            for(int j=0;j<L3;j++)
                for(int k=0;k<L2;k++){
                    res[i][j]+=a[i][k]*b[k][j]%1000000007;
                    res[i][j]%=1000000007;
                }
        return res;
    }
}