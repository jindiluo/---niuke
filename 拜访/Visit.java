/**
 *
 */
/**
 * @author Administrator
 *
 */
package �ݷ�;
//Ҫע��i,j��x,y�Ķ�Ӧ��ϵ������д��

public class Visit {
  public int countPath(int[][] map, int n, int m) {
       // write code here
      int x1=0,y1=0;//����
      int x2=0,y2=0;//�̼�
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(map[i][j]==2){
                  x1=j;
                  y1=i;
              }
              else if(map[i][j]==1){
                  x2=j;
                  y2=i;
              }
          }
      }
      if(x1==x2&&y1==y2){// �����غ�
          return 1;
      }
      //�ֱ��ȡx,y�Ĳ�ֵ
      int xto = x1>x2?-1:1;
      xto = (x1==x2)?0:xto;
      int yto = y1>y2?-1:1;
      yto = (y1==y2)?0:yto;
      //ά��һ�����飬��¼
      int dp[][] = new int[n][m];
      //ע�⣬y��Ӧi��x��Ӧj
      dp[y1][x1] = 1;
      //��������
      for(int i=y1+yto;i!=y2+yto;i+=yto){
          dp[i][x1] = (map[i][x1]==-1)?0:dp[i-yto][x1];
      }
      //���º���
      for(int j=x1+xto;j!=x2+xto;j+=xto){
          dp[y1][j] = (map[y1][j]==-1)?0:dp[y1][j-xto];
      }
      //��������λ��
      for(int i=y1+yto;i!=y2+yto;i+=yto){
          for(int j=x1+xto;j!=x2+xto;j+=xto){
              dp[i][j] = (map[i][j]==-1)?0:dp[i-yto][j]+dp[i][j-xto];
          }
      }
      return dp[y2][x2];
  }
}