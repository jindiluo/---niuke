/**
 *
 */
/**
 * @author Administrator
 *
 */
package ������Ӵ�;



public class Palindrome {
    //�жϻ��ĵĺ���
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
                //����ѭ�����������е��Ӵ���������һ�ж��Ƿ��ǻ���
                if(isHuiWen(A.substring(i, j),j-i)){
                    if(j-i>maxlen)
                        maxlen=j-i;
                }
            }
        }
        return maxlen;
    }
}
