/**
 *
 */
/**
 * @author Administrator
 *
 */
package Ğ¡ÇòµÄ¾àÀë;

public class Balls {

public int calcDistance(int A, int B, int C, int D) {
    return (int)Math.round(countDis(A*1.0)+countDis(B*1.0)+countDis(C*1.0)+countDis(D*1.0));
}

/**
 *
 * @param a
 * @return
 */
private double countDis(double a) {
    double dis = a;
    while (a > 0) {
        a /= 2.0;
        dis += 2*a;
    }
    return dis;
}
}