/**
 *
 */
/**
 * @author Administrator
 *
 */
package 表达式合法判断;
import java.util.Stack;

public class ChkExpression {
   public static boolean chkLegal(String A) {
        StringBuffer sb = new StringBuffer(A);
        int length = sb.length();
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = sb.charAt(i);
            if (c == '{' || c == '['  || c == '(' ){
                s.push(c);
            }
            if ( c == '}'   || c == ']'  || c == ')'){
                s.pop();
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }
}