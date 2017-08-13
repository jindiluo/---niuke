/**
 *
 */
/**
 * @author Administrator
 *
 */
package 多组数中位数;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int getUpMedian(int[] arr1, int[] arr2) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         //合并两个数组
         for(int i=0; i<arr1.length; i++){
             list.add(arr1[i]);
         }
         for(int i=0; i<arr2.length; i++){
             list.add(arr2[i]);
         }
         Collections.sort(list);            //排序
         int len = list.size();             //获取list长度
         return list.get(len/2 - 1);        //len/2 - 1:中位数下标
    }
}