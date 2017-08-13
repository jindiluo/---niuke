/**
 *
 */
/**
 * @author Administrator
 *
 */
package Ѱ��;

//ʹ��Cruskal�������
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//���鼯ʵ����С������
public class Main{
  private static class Edge{
      //�����յ�
      int x,y;
      int weight;
      public Edge(int x,int y,int weight)
      {
          this.x=x;
          this.y=y;
          this.weight=weight;
      }
  }
  public static int father(int i,int a[])
  {
       int k=i;
       while(a[k]!=k)k=a[k];  //���鼯
       return k;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner in=new Scanner(System.in);
      while(in.hasNext())
      {
          int n=in.nextInt();
          int m=in.nextInt();
          Edge[] edges=new Edge[m];
          for(int i=0;i<m;i++)
          {
              edges[i]=new Edge(in.nextInt(),in.nextInt(),in.nextInt());
          }
          int a[]=new int[n+1];
          for(int j=0;j<=n;j++)
          {
              a[j]=j;
          }
          Arrays.sort(edges,new Comparator<Edge>() {
              @Override
              public int compare(Edge o1, Edge o2) {
                  // TODO Auto-generated method stub
                  return o1.weight-o2.weight;
              }
          });
          int res=0;
          for(int i=0;i<m;i++)
          {
              int px=father(edges[i].x,a);
              int py=father(edges[i].y,a);
              if(px!=py)
              {
                   if(edges[i].weight>res)res=edges[i].weight;
                   if(px>py)
                       a[px]=py;
                   else
                       a[py]=px;
              }
          }
          System.out.println(res);
      }
  }

}