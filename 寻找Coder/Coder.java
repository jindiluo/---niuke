/**
 *
 */
/**
 * @author Administrator
 *
 */
package 寻找Coder;
//若用indexOf(String str)方法无法处理大小写，用equalsIgnorecase()
import java.util.ArrayList;

public class Coder {
  public String[] findCoder(String[] A, int n) {
      // write code here
      String tarCoder = "coder";
      int tarLen = "coder".length();
      int[] count = new int[A.length];    //定义一个辅助数组用于排序
      for(int i=0;i<A.length;i++){
          for(int j=0;j<=A[i].length()-tarLen;j++){
               if(A[i].substring(j,tarLen+j).equalsIgnoreCase(tarCoder)){
                   j=j+tarLen-1;          //循环中还加一次
                   count[i]++;
               }
          }
      }
      //count[i]和A[i]是一一对应的
      //对count[]进行稳定排序（冒泡排序是稳定排序）
      int temp=0;
      String stemp=null;
      for(int i=1;i<count.length;i++){
          for(int j=0;j<count.length-i;j++){
              if(count[j]<count[j+1]){
                  temp = count[j];
                  count[j] = count[j+1];
                  count[j+1]=temp;
                  //count[]在移动的同时，A[]也随着移动
                  stemp = A[j];
                  A[j]=A[j+1];
                  A[j+1]=stemp;
              }
          }
      }
      //去掉count[]中带0的，即A[]中没有目标字符串的
      ArrayList<String> list = new ArrayList<String>();
      for(int i=0;i<count.length;i++){
          if(count[i]!=0){
              list.add(A[i]);
          }
      }
      //转成数组
      String[] s = new String[list.size()];
      return list.toArray(s);
  }
}