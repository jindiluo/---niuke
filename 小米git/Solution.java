package 小米git;
import java.util.*;
public class Solution {
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        // 将matrix转为二维数组
        int[][] am = new int[matrix.length][matrix[0].length()];
        for (int i = 0; i < am.length; i ++ ) {
            for (int j = 0; j < am[0].length; j ++ ) {
                am[i][j] = Integer.parseInt(String.valueOf(matrix[i].charAt(j)));
            }
        }
        // 根节点到indexA结点的路径
        List<Integer> Apath = DFS(am, indexA);
        // 根节点到indexB结点的路径
        List<Integer> Bpath = DFS(am, indexB);
        int len = Apath.size() > Bpath.size() ? Bpath.size() : Apath.size();
        int u = 0;
        // 输出路径中最后一个相同的结点
        for (int i = 0; i < len; i ++ ) {
            if(Apath.get(i) == Bpath.get(i)) u = Apath.get(i);
        }
        return u;
    }
    public static List<Integer> DFS(int[][] am, int indexA) {
        boolean[] visited = new boolean[am.length];
        visited[0] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        while (stack.peek() != indexA) {
            boolean findedNext = false;
            int u = stack.peek();
            for (int j = 0; j < am.length; j ++ ) {
                if( ! visited[j] && am[u][j] == 1) {
                    u = j;
                    stack.push(u);
                    visited[u] = true;
                    path.add(u);
                    findedNext = true;
                    break;
                }
            }
            if( ! findedNext) {
                stack.pop();
                path.remove(path.size() - 1);
            }
        }
        return path;
    }
}
