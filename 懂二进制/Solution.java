package ��������;

public class Solution {
    /**
     * ����������ζ����Ʊ��λ����ͬ������
     *
     * @param m ����m
     * @param n ����n
     * @return ����
     */


public int countBitDiff(int m, int n) {

        int dif=m^n;//�Ƚ�������������㣬�õ������
        int cnt=0;
        while(dif!=0){
            dif=dif&(dif-1);
            cnt++;
        }             //ͳ��һ������dif���ж��ٸ�1��
        return cnt;
    }

}
