/**
 *
 */
/**
 * @author Administrator
 *
 */
package �׸��ظ��ַ�;
import java.util.HashMap;

public class FirstRepeat {

    /**
     *
     *
     * HashMap��
     *
     * @param A
     * @param n
     * @return
     */
    public char findFirstRepeat(String A, int n) {

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        char[] charArray = A.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (hm.get(charArray[i]) == null) {
                hm.put(charArray[i], 1);
            } else {
                return charArray[i];
            }
        }

        return '\n';
    }
}