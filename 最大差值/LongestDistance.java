/**
 *
 */
/**
 * @author Administrator
 *
 */
package 最大差值;
//记录当前最小数，及最大距离；
//每一位数与它之前的最小数之差 为该数的最大距离；
//该最大距离与最大距离比较，更新最大距离；
public class LongestDistance {
  public int getDis(int[] A, int n) {
      int minV=A[0];//最小的数
      int maxDis=0;//最大距离
      for(int i=1;i<n;i++ ){
          if(A[i]<minV) minV=A[i];
          int tmpD=A[i]-minV;
          if(tmpD>maxDis)  maxDis=tmpD;
      }
      return maxDis;
  }
}