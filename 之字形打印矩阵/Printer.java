/**
 * 
 */
/**
 * @author Administrator
 *
 */
package 之字形打印矩阵;
import java.util.*;


public class  Printer{
public int[] printMatrix(int[][] mat, int n, int m) {
    int[] arr = new int [n*m];
    //hang记录你的行数，count记录的是你返回的字符数组的长度
     int hang = 0;
     int count = 0;
       //偶数行顺序，奇数行倒序
       for(int i = 0; i < mat.length; i++ ){
           for(int j = 0; j < mat[i].length; j++){
               //判断数奇数行还是偶数行
               if(hang%2 == 0){
                   arr[count++] = mat[i][j];
               }else{
                   arr[count++] = mat[i][m-1-j];
               }
           }
           //写完了一行，行数需要+1
           hang++;
       }
       return arr;
   }
}