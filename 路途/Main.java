/**
 *
 */
/**
 * @author Administrator
 *
 */
package 路途;


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
     * Dijkstra算法
     * @param graph : 路径，路径的权值等于两个端点处的搭讪值
     * @param isVisited ： 记录某个站点是否被访问过
     * @param startId : 起始点，即1
     * @param endId : 终点，即n
     * @param k : 存储每个站点的搭讪值
     * @return： 返回起点到站点的最短路径
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
                        //更新路径
                        graph[startId][i]=graph[startId][nearest]+graph[nearest][i];
                        if(nearest!=startId) //注意对于路径中除了首尾节点，中间的每个站点实际上多算了一个被搭讪值，需要减去
                            graph[startId][i]-=k[nearest];
                    }

                }
            }
        }
        return graph[startId][endId];
    }
}