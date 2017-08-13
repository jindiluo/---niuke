/**
 *
 */
/**
 * @author Administrator
 *
 */
package 构造MAXTREE;



public class MaxTree {
     public int[] buildMaxTree(int[] arr, int n) {
            int []res=new int[n];
            for(int index=0 ;index <n ;index++){
                int left=index,right=index;
                //往左边找到第一个比当前数大的。
                for(int i=index-1 ; i>=0 ;i--){
                    if(arr[i]>arr[index]){
                        left=i;
                        break;
                    }
                }
                //往右边找到第一个比当前数大的。
                for(int j=index+1 ;j<n ;j++){
                    if(arr[j]>arr[index]){
                        right=j;
                        break;
                    }
                }
                //数组中值最大者作为根节点
                if(left==index&&right==index)
                     res[index]=-1;
                else if (left==index) {
                    res[index]=right;
                }else if (right==index) {
                    res[index]=left;
                }else {
                    //选left和right中较小者作为当前节点的父亲节点
                    if(arr[left] < arr[right])
                        res[index]=left;
                    else
                        res[index]=right;
                }
            }
            return res;
        }
}