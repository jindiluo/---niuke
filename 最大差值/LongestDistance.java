/**
 *
 */
/**
 * @author Administrator
 *
 */
package ����ֵ;
//��¼��ǰ��С�����������룻
//ÿһλ������֮ǰ����С��֮�� Ϊ�����������룻
//����������������Ƚϣ����������룻
public class LongestDistance {
  public int getDis(int[] A, int n) {
      int minV=A[0];//��С����
      int maxDis=0;//������
      for(int i=1;i<n;i++ ){
          if(A[i]<minV) minV=A[i];
          int tmpD=A[i]-minV;
          if(tmpD>maxDis)  maxDis=tmpD;
      }
      return maxDis;
  }
}