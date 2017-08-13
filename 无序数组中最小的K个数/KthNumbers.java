/**
 *
 */
/**
 * @author Administrator
 *
 */
package ������������С��K����;


import java.util.Arrays;

public class KthNumbers {
    //��A[low,hign]������
    public int partition(int[]A, int low, int high) {
        int pivot = A[low];
        while (low < high) {
            while (low < high && A[high] >= pivot)
                high--;
            if (low < high)
                A[low++] = A[high];
            while (low < high && A[low] <= pivot)
                low++;
            if (low < high)
                A[high--] = A[low];
        }
        A[low] = pivot;
        return low;
    }
    //��ȡA�е�kС����
    public int getKst(int[]A, int n, int k) {
        int i = partition(A, 0, n - 1);
        while (i != k - 1) {
            if (i < k - 1)
                i = partition(A, i + 1, n - 1);
            else
                i = partition(A, 0, i - 1);
        }
        return A[i];

    }
    public int[]findKthNumbers(int[]A, int n, int k) {
        // write code here
        int kst = getKst(Arrays.copyOf(A, n), n, k);
        int[]nums = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++)
            if (A[i] <= kst)
                nums[j++] = A[i];
        return nums;
    }
}