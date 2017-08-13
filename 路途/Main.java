/**
 *
 */
/**
 * @author Administrator
 *
 */
package ·;;


import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final int Max=60000000;
        while(scanner.hasNext())
        {
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] k=new int[n+1];
            for(int i=0; i<n; i++)
            {
                int data=scanner.nextInt();
                k[i+1]=data;
            }
            int[][] graph=new int[n+1][n+1];
            for(int i=0; i<=n; i++)
                for(int j=0; j<=n; j++)
                    graph[i][j]=(i==j? 0 : Max);
            for(int i=0; i<m; i++)
            {
                int startid=scanner.nextInt();
                int endid=scanner.nextInt();
                graph[startid][endid]=graph[endid][startid]=k[startid]+k[endid];
            }

            boolean[] isVisited=new boolean[n+1];
            isVisited[1]=true;
            int least=shortPath(graph, isVisited, 1, n, k);
            System.out.println(least);
        }
    }
    /**
     * Dijkstra�㷨
     * @param graph : ·����·����Ȩֵ���������˵㴦�Ĵ�ڨֵ
     * @param isVisited �� ��¼ĳ��վ���Ƿ񱻷��ʹ�
     * @param startId : ��ʼ�㣬��1
     * @param endId : �յ㣬��n
     * @param k : �洢ÿ��վ��Ĵ�ڨֵ
     * @return�� ������㵽վ������·��
     *
     */

    private static int shortPath(int[][] graph, boolean[] isVisited, int startId,
            int endId, int[] k) {
        // TODO Auto-generated method stub
        int nearest=0;
        while(true)
        {
            nearest=0;
            for(int i=1; i<=endId; i++)
            {
                if(isVisited[i]==false)
                {
                    if(graph[startId][i]<graph[startId][nearest])
                        nearest=i;
                }
            }
            if(nearest==endId)
                break;
            isVisited[nearest]=true;
            for(int i=1; i<=endId; i++)
            {
                if(isVisited[i]==false)
                {
                    if(graph[startId][i]>graph[startId][nearest]+graph[nearest][i])
                    {
                        //����·��
                        graph[startId][i]=graph[startId][nearest]+graph[nearest][i];
                        if(nearest!=startId) //ע�����·���г�����β�ڵ㣬�м��ÿ��վ��ʵ���϶�����һ������ڨֵ����Ҫ��ȥ
                            graph[startId][i]-=k[nearest];
                    }

                }
            }
        }
        return graph[startId][endId];
    }
}