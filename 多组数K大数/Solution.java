/**
 *
 */
/**
 * @author Administrator
 *
 */
package ������K����;

import java.util.Arrays;
//˼�룺����֮��ȡ��K�������ɡ�
public class Solution {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int []a=new int[arr1.length+arr2.length];
        for(int i=0; i<arr1.length ;i++){
            a[i]=arr1[i];
        }
        for(int j=arr1.length; j<arr1.length+arr2.length;j++){
            a[j]=arr2[j-arr1.length];
        }
        Arrays.sort(a);
        return a[kth-1];
    }
}
