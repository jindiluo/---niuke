/**
 *
 */
/**
 * @author Administrator
 *
 */
package ��������λ��;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int getUpMedian(int[] arr1, int[] arr2) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         //�ϲ���������
         for(int i=0; i<arr1.length; i++){
             list.add(arr1[i]);
         }
         for(int i=0; i<arr2.length; i++){
             list.add(arr2[i]);
         }
         Collections.sort(list);            //����
         int len = list.size();             //��ȡlist����
         return list.get(len/2 - 1);        //len/2 - 1:��λ���±�
    }
}