/**
 *
 */
/**
 * @author Administrator
 *
 */
package ×Ö·û´®Ìæ»»;

public class  StringFormat{

public String formatString(String A, int n, char[] arg, int m) {
         int i = 0;
        while (A.indexOf("%s") >= 0) {
            A = A.replaceFirst("%s", String.valueOf(arg[i]));
            i++;
        }
        while (i < m) {
            A += arg[i];
            i++;
        }
        return A;
}
}