/**
 *
 */
/**
 * @author Administrator
 *
 */
package 股票交易日;


//已通过测试，发现好多人都不喜欢写注释，喜欢直接粘代码，
public class Stock {
    //简单说一下我的做题思路，
    //其实我的原始思路是用二分法做，先把数组从中间分开，
    //然后在两部分中分别找最大差值，然后保存最大差值进行相加
    //完事之后，将中间的指针，也就是进行二分的指针向右移或者向左移
    //又划分成了两部分，依次找最大差值，
    //直到最后两个差值之和为最大值，返回最大值。
    public int maxProfit(int[] prices, int n) {
        int temp1 = 0,temp2 = 0 , temp3 = 0, l = 0;
        //既然从中间划分两部分，之后又要在往前划分和往后划分，
        //所以直接一开始就从最前面开始划分，将数组划分两部分
        while(l<n){
            //l变量用来划分数组
            //第一个for循环寻找的最大差值，仅限于l变量之前。
             for(int i = 0 ; i < l+1 ; i++){
                for(int j = i+1 ; j < l+1 ; j++){
                    if(prices[j]-prices[i]>temp1){
                        temp1 = prices[j]-prices[i];
                    }
                }
            }
            //第二个for循环寻找的最大差值，仅限于l变量之后。
            for(int i = l+1 ; i < n ; i++){
                for(int j = i+1 ; j < n ; j++){
                    if(prices[j]-prices[i]>temp2){
                        temp2 = prices[j]-prices[i];
                    }
                }
            }
            //判断两个变量之和是否是最大差值
            if(temp2+temp1>temp3){
                 temp3 = temp2+temp1 ;
            }
            //此处一定要将两个部分的最大差值重新置0；
            //否则结果会出错。因为它里面存有之前的最大差值
            //如果不重置，那么最后在判断的时候会重复计算。
            temp2 = 0 ;
            temp1 = 0;
            l++;
        }
        return temp3;
    }
}