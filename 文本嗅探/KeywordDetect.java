/**
 *
 */
/**
 * @author Administrator
 *
 */
package 文本嗅探;
import java.util.ArrayList;

public class KeywordDetect {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        // write code here
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<keys.length;j++){
                if(A[i].indexOf(keys[j])!=-1){
                    a.add(i);
                    break;
                }
            }
        }
        if(a.size()==0){
            a.add(-1);
        }
        //int[] res = new int[a.size()];
        Integer[] res =new Integer[a.size()];
        res = a.toArray(res);
        //本来结果已经出来了，无赖Integer[]不能自动拆箱成int[]
        int[] r = new int[res.length];
        for(int i=0;i<res.length;i++){
            r[i]=res[i].intValue();       //手动拆箱
        }
        return r;
    }

}