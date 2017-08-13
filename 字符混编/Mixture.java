/**
 *
 */
/**
 * @author Administrator
 *
 */
package ×Ö·û»ì±à;



public class Mixture {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        if(v!=n+m)
            return false;
        char[] SA=A.toCharArray();
        char[] SB=B.toCharArray();
        char[] SC=C.toCharArray();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            if(SA[i-1]!=SC[i-1])
                break;
            dp[i][0]=true;
        }
        for(int j=1;j<m+1;j++){
            if(SB[j-1]!=SC[j-1])
                break;
            dp[0][j]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if((SA[i-1]==SC[i+j-1] && dp[i-1][j]) || (SB[j-1]==SC[i+j-1] && dp[i][j-1]))
                    dp[i][j]=true;
            }
        }
        return dp[n][m];
    }
}