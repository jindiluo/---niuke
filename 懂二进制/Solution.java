package 懂二进制;

public class Solution {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */


public int countBitDiff(int m, int n) {

        int dif=m^n;//先将二者做异或运算，得到结果；
        int cnt=0;
        while(dif!=0){
            dif=dif&(dif-1);
            cnt++;
        }             //统计一个整数dif含有多少个1；
        return cnt;
    }

}
