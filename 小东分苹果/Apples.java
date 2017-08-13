/**
 *
 */
/**
 * @author Administrator
 *
 */
package 小东分苹果;

public class Apples {
    public int getInitial(int n) {
        int apple = 1 ;
        for(int i=0;i<n;i++){
            apple = apple*n ;
        }
        return apple-(n-1) ;
    }
}