/**
 *
 */
/**
 * @author Administrator
 *
 */
package ’€÷ΩŒ Ã‚;

import java.util.LinkedList;
import java.util.List;

public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        List<String> list = new LinkedList<String>();
        fold(n,list,"down");
        String[] strs = new String[(int) (Math.pow(2,n)-1)];
        return list.toArray(strs);
    }

    public static void fold(int n, List<String> list,String str){
        if(n != 0){
            fold(n-1,list,"down");
            list.add(str);
            fold(n-1,list,"up");
        }
    }
}