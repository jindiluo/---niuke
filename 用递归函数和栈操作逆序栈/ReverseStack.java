/**
 *
 */
/**
 * @author Administrator
 *
 */
package ÓÃµÝ¹éº¯ÊýºÍÕ»²Ù×÷ÄæÐòÕ»;


public class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        recursion(stack,0);
        return stack;
    }
    void recursion(int[] stack, int i){
        if(i>=stack.length/2)
            return;
        recursion(stack,i+1);
        int temp = stack[stack.length-i-1];
        stack[stack.length-i-1] = stack[i];
        stack[i] = temp;
        return;
    }
}
