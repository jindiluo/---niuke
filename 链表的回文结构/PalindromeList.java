/**
 *
 */
/**
 * @author Administrator
 *
 */
package 链表的回文结构;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}



public class PalindromeList {
    public boolean chkPalindrome(ListNode a) {
        // write code here
        if(a==null)
            return false;
        ListNode mid = a;
        ListNode fast = a;
        ListNode temp = mid;
        while(fast!=null){
            temp = mid;
            mid = mid.next;
            fast = fast.next;
            if(fast!=null)
                fast = fast.next;
        }
        if(mid==null)
            return true;
        temp.next = null;
        ListNode cur = mid.next;
        mid.next = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = mid;
            mid = cur;
            cur = temp;
        }
        while(a!=null&&mid!=null){
            if(a.val!=mid.val)
                return false;
            a = a.next;
            mid = mid.next;
        }
        return a==null||a.next==null;
    }
}