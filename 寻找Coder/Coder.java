/**
 *
 */
/**
 * @author Administrator
 *
 */
package Ѱ��Coder;
//����indexOf(String str)�����޷������Сд����equalsIgnorecase()
import java.util.ArrayList;

public class Coder {
  public String[] findCoder(String[] A, int n) {
      // write code here
      String tarCoder = "coder";
      int tarLen = "coder".length();
      int[] count = new int[A.length];    //����һ������������������
      for(int i=0;i<A.length;i++){
          for(int j=0;j<=A[i].length()-tarLen;j++){
               if(A[i].substring(j,tarLen+j).equalsIgnoreCase(tarCoder)){
                   j=j+tarLen-1;          //ѭ���л���һ��
                   count[i]++;
               }
          }
      }
      //count[i]��A[i]��һһ��Ӧ��
      //��count[]�����ȶ�����ð���������ȶ�����
      int temp=0;
      String stemp=null;
      for(int i=1;i<count.length;i++){
          for(int j=0;j<count.length-i;j++){
              if(count[j]<count[j+1]){
                  temp = count[j];
                  count[j] = count[j+1];
                  count[j+1]=temp;
                  //count[]���ƶ���ͬʱ��A[]Ҳ�����ƶ�
                  stemp = A[j];
                  A[j]=A[j+1];
                  A[j+1]=stemp;
              }
          }
      }
      //ȥ��count[]�д�0�ģ���A[]��û��Ŀ���ַ�����
      ArrayList<String> list = new ArrayList<String>();
      for(int i=0;i<count.length;i++){
          if(count[i]!=0){
              list.add(A[i]);
          }
      }
      //ת������
      String[] s = new String[list.size()];
      return list.toArray(s);
  }
}