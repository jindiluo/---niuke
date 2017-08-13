/**
 *
 */
/**
 * @author Administrator
 *
 */
package �ַ�����;


/*1.���ַ���תΪ�ַ����飬����ͳ��ÿ���ַ����ֵĴ���������hash����

  2.�����ڵ�TreeNode������һ�����ȶ���
  3.�������������ϲ�����Ȩ����С�Ľڵ㣬ֱ��ֻʣ�¸��ڵ�root

  4.������ȱ����������㳤�Ⱥ�
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.nextLine();
            int result = hafuman(s);
            System.out.println(result);
        }
    }

    public static int hafuman(String s) {
        char[] chars = s.toCharArray();
        //hash����ÿ���ַ��ͳ��ֵĴ���
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (hash.containsKey(chars[i])) {
                hash.put(chars[i], hash.get(chars[i]) + 1);
            } else {
                hash.put(chars[i], 1);
            }
        }
        //���ȶ��У���С�ƣ���ÿ���ܵõ�weigh��С��node
        Queue<TreeNode> q = new PriorityQueue<>(hash.size(), new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
            q.offer(new TreeNode(entry.getValue(), entry.getKey()));
        }
        while (q.size() > 1) {
            //����������С�ģ��ϲ�Ϊһ��node
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            TreeNode father = new TreeNode(left.weight + right.weight);
            father.left = left;
            father.right = right;
            q.offer(father);
        }
        TreeNode root = q.poll();
        //���㳤��
        return valLength(root, 0);
    }

    public static int valLength(TreeNode node, int depth) {
        if (node == null) return 0;//������ch��ֵ��
        return (node.ch == null ? 0 : node.weight) * depth + valLength(node.left, depth + 1) + valLength(node.right, depth + 1);
    }

    static class TreeNode {
        int weight;//Ȩ�أ����ִ���
        Character ch;//����ǳ�ʼ�ַ�����chΪ�ַ�������Ǻϲ��ģ���Ϊnull
        TreeNode left;
        TreeNode right;

        public TreeNode(int weight) {
            this.weight = weight;
        }

        public TreeNode(int weight, Character ch) {
            this.weight = weight;
            this.ch = ch;
        }
    }
}