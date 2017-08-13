/**
 * 
 */
/**
 * @author Administrator
 *
 */
package Ë³Ê±ÕëĞı×ª¾ØÕó;
import java.util.*;

public class Rotate {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] temp=new int[n][n];
         
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                temp[j][n-1-i]=mat[i][j];                
            }
        }        
        return temp;    
    }
}