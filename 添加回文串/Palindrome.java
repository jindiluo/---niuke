/**
 *
 */
/**
 * @author Administrator
 *
 */
package 添加回文串;


import java.util.Stack;
//思路:由于只能在结尾添加,所以可以采取从开头删除字符直到回文,再逆序(用栈)输出就是添加至结尾的字符串
public class Palindrome {

    public String addToPalindrome(String A, int n) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<n-1; i++){                    //注意这里i到n-1
            if(!isHuiWen(A.substring(i, n))){       //剩下的子串不回文就把前面的字符入栈
                stack.push(A.charAt(i));
            }else{
                break;
            }
        }

        while(!stack.isEmpty()){                //剩下的子串回文就把前面的字符弹出,找到了添加的回文串
            char c = stack.pop();
            buffer.append(c);
        }
        return buffer.toString();
    }

    public boolean isHuiWen(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}