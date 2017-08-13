/**
 *
 */
/**
 * @author Administrator
 *
 */
package 拓扑结构相同的子树;





public class IdenticalTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        if (A == null && B != null) {     //这句不能掉，否则可能会抛出空指针异常
            return false;
        }
        if (isIdentical(A, B)) {
            return true;
        }
        if (chkIdentical(A.left, B)) {
            return true;
        } else if (chkIdentical(A.right, B)) {
            return true;
        }
        return false;
    }
    public boolean isIdentical(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        return A.val == B.val && isIdentical(A.left, B.left) && isIdentical(A.right, B.right);
    }
}