/**
 * 
 */
/**
 * @author Administrator
 *
 */
package ֮���δ�ӡ����;
import java.util.*;


public class  Printer{
public int[] printMatrix(int[][] mat, int n, int m) {
    int[] arr = new int [n*m];
    //hang��¼���������count��¼�����㷵�ص��ַ�����ĳ���
     int hang = 0;
     int count = 0;
       //ż����˳�������е���
       for(int i = 0; i < mat.length; i++ ){
           for(int j = 0; j < mat[i].length; j++){
               //�ж��������л���ż����
               if(hang%2 == 0){
                   arr[count++] = mat[i][j];
               }else{
                   arr[count++] = mat[i][m-1-j];
               }
           }
           //д����һ�У�������Ҫ+1
           hang++;
       }
       return arr;
   }
}