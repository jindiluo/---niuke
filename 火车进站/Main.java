package 火车进站;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] train = new int[n];
            int[] origin = new int[n];
            for(int i = 0; i < n; i++){
                train[i] = in.nextInt();
                origin[i] = train[i];
            }
            Arrays.sort(train);
            nextPermutation(origin, train);//输出从小到大排序后的全排列
        }
        in.close();
    }

    //字典序全排列
    private static void nextPermutation(int[] origin, int[] array){
        while(true){
            if(checkLegal(origin, array)){
                print(array);
            }
            int i;
            boolean flag = false;
            for(i = array.length - 2; i >= 0; i--){//找到第一个比右边小的数字的下标
                if(array[i] < array[i + 1]){
                    flag = true;//表示存在这样的数字
                    break;
                }
            }
            if(!flag){//如果不存在这样的数字说明输出了所有的排列，跳出while
                break;
            }
            int min = -1;
            boolean findFirst = false;
            for(int j = i + 1; j < array.length; j++){//找到i的右边比array[i]大的数中最小的一个的下标min
                if(findFirst) {//是否找到第一个min
                    if (array[j] > array[i] && array[j] < array[min]) {
                        min = j;
                    }
                }
                else{
                    if(array[j] > array[i]){
                        min = j;
                        findFirst = true;
                    }
                }
            }
            if(min == -1){//如果没有比array[i]大的数则进行下一次循环
                continue;
            }
            //交换array[i]与array[min]
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            //反转i之后的所有数字
            for(int front = i + 1, back = array.length - 1; front <= i + (array.length - i - 1) / 2; front++, back--){
                temp = array[front];
                array[front] = array[back];
                array[back] = temp;
            }
        }
    }

    private static boolean checkLegal(int[] origin, int[] array){
        if(array.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < origin.length; i++){
            stack.push(origin[i]);
            while(!stack.empty() && stack.peek() == array[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    private static void print(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(array[array.length - 1]);
    }
}