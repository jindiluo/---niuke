/**
 *
 */
/**
 * @author Administrator
 *
 */
package ��ڵ���_�й�ţ��;
public class Solution {
    /**
     * �������ܻ�õ��������
     *
     * @param prices Prices[i]����i��Ĺɼ�
     * @return ����
     */


//��̬�滮:������ɨ��һ��,dpl[i]��ʾ��iλ����������;�����������:��minIȡ���������ʱ��Сֵ��λ��
    //��arr[i+1]>arr[i],��dpl[i+1]=dp[i] ����=arr[i+1]-arr[minI]
    //��arr[i+1]<arr[i],dpl[i+1]=dp[i],��arr[i+1]<arr[minI],�����minIΪarr[i+1]
    //�ٴ�������ɨ�����dpr[i],ͬ��
    public int calculateMax(int[] prices) {
        if(prices==null || prices.length==0 || prices.length<2 || prices.length>100){
            return 0;
        }

        int len = prices.length;
        int[] dpl = new int[len];
        dpl[0] = 0;
        int minI = 0;
        for(int i=1; i<len; i++){   //������ɨ��һ�����dpl����
            if(prices[i]>prices[i-1]){
                dpl[i] = Math.max(prices[i]-prices[minI],dpl[i-1]);
            } else{
                dpl[i] = dpl[i-1];
                if(prices[i]<prices[minI])
                    minI = i;
            }
        }

        int[] dpr = new int[len];
        dpr[len-1] = 0;
        int maxI = len-1;
        for(int i=len-2; i>=0; i--){//���ҵ���ɨ��һ�����dpr����
            if(prices[i]<prices[i+1]){
                dpr[i] = Math.max(prices[maxI]-prices[i], dpr[i+1]);
            } else{
                dpr[i] = dpr[i+1];
                if(prices[i]>prices[maxI]){
                    maxI = i;
                }
            }
        }

        int res = 0;
        for(int i=0; i<len; i++){ //�Ƚϵó����ֵ
            res = Math.max(dpl[i]+dpr[i], res);
        }
        return res;

    }
}