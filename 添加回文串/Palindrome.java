/**
 *
 */
/**
 * @author Administrator
 *
 */
package ��ӻ��Ĵ�;


import java.util.Stack;
//˼·:����ֻ���ڽ�β���,���Կ��Բ�ȡ�ӿ�ͷɾ���ַ�ֱ������,������(��ջ)��������������β���ַ���
public class Palindrome {

    public String addToPalindrome(String A, int n) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<n-1; i++){                    //ע������i��n-1
            if(!isHuiWen(A.substring(i, n))){       //ʣ�µ��Ӵ������ľͰ�ǰ����ַ���ջ
                stack.push(A.charAt(i));
            }else{
                break;
            }
        }

        while(!stack.isEmpty()){                //ʣ�µ��Ӵ����ľͰ�ǰ����ַ�����,�ҵ�����ӵĻ��Ĵ�
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