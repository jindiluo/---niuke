/**
 *
 */
/**
 * @author Administrator
 *
 */
package ���ֲ���;
/**
ȥ�Ķ�������

���ֲ���
��Ŀ����:
����һ���������飬����ͨ�����ö��ֲ��ҵķ�ʽ����λĳһԪ�أ����д���ֲ��ҵ��㷨���������в���ָ��Ԫ�ء�
����һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1��
����Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á�
����������
[1,3,5,7,9],5,3
���أ�1
 */
public class BinarySearch {
    public int getPos(int[] A, int n, int key) {
        if (A == null) {
            return -1;
        }
        int low = 0;
        int high = A.length - 1;
        int ret = -1;
        while (low <= high) {
            int mid = (low + high) /2;
            if (A[mid] == key) {
                ret = mid;
                high = mid - 1;
            } else if (A[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ret;
    }
}