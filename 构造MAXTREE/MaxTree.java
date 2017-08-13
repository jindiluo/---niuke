/**
 *
 */
/**
 * @author Administrator
 *
 */
package ����MAXTREE;



public class MaxTree {
     public int[] buildMaxTree(int[] arr, int n) {
            int []res=new int[n];
            for(int index=0 ;index <n ;index++){
                int left=index,right=index;
                //������ҵ���һ���ȵ�ǰ����ġ�
                for(int i=index-1 ; i>=0 ;i--){
                    if(arr[i]>arr[index]){
                        left=i;
                        break;
                    }
                }
                //���ұ��ҵ���һ���ȵ�ǰ����ġ�
                for(int j=index+1 ;j<n ;j++){
                    if(arr[j]>arr[index]){
                        right=j;
                        break;
                    }
                }
                //������ֵ�������Ϊ���ڵ�
                if(left==index&&right==index)
                     res[index]=-1;
                else if (left==index) {
                    res[index]=right;
                }else if (right==index) {
                    res[index]=left;
                }else {
                    //ѡleft��right�н�С����Ϊ��ǰ�ڵ�ĸ��׽ڵ�
                    if(arr[left] < arr[right])
                        res[index]=left;
                    else
                        res[index]=right;
                }
            }
            return res;
        }
}