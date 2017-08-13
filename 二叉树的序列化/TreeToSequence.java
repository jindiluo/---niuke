/**
 *
 */
/**
 * @author Administrator
 *
 */
package 二叉树的序列化;



/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreeToSequence {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
    public String toSequence(TreeNode root) {
        // write code here
        String str="";
        if(root==null){
            return "";
        }else{
            str="(";
            str+=toSequence(root.left);
            str+=toSequence(root.right);
            str+=")";
            return str;
        }
    }
}