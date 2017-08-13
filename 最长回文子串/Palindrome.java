/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最长回文子串;



public class Palindrome {
    //判断回文的函数
    public boolean isHuiWen(String A, int n){
        int k = n / 2;
        for (int i = 0; i < k; ++i)
        {
            if (A.charAt(i) != A.charAt(n-1-i))
                return false;
        }
        return true;
    }
    public int getLongestPalindrome(String A, int n) {
        int maxlen=0;
        for(int i=0 ;i< n ;i++){
            for(int j=i+1 ;j<=n ;j++){
                //两层循环遍历出所有的子串，并且逐一判断是否是回文
                if(isHuiWen(A.substring(i, j),j-i)){
                    if(j-i>maxlen)
                        maxlen=j-i;
                }
            }
        }
        return maxlen;
    }
}
