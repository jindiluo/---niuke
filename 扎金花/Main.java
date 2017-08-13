/**
 *
 */
/**
 * @author Administrator
 *
 */
package Ôú½ð»¨;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s1 = scan.next();
            String s2 = scan.next();
            char[] c1 = s1.trim().replaceAll("0", "").toCharArray();
            char[] c2 = s2.trim().replaceAll("0", "").toCharArray();
            scan.nextLine();
           // try{
                System.out.println(new Main().new pai(c1).compareTo(new Main().new pai(c2)));
            //}catch(Exception e){
             //   System.out.println(-2);

           // }
        }
    }

    class pai implements Comparable<pai> {
        private final static int BAO = 3;
        private final static int SHUN = 2;
        private final static int DUI = 1;
        private final static int PU = 0;
        private final static int LO = 10;
        private final static int J = 11;
        private final static int Q = 12;
        private final static int K = 13;
        private final static int A = 14;
        private int rank;
        private int[] sanpai;
        private final char[] stringPai;

        public pai(char[] c1) {
            stringPai = c1;
            sanpai = digitPai();
            SortPai();
            setRank();
        }

        private int[] digitPai() {
            sanpai = new int[stringPai.length];
            for (int i = 0; i < stringPai.length; i++) {
                if (stringPai[i] == '1')
                    sanpai[i] = 10;
                else if (stringPai[i] == 'J' || stringPai[i] == 'j')
                    sanpai[i] = 11;
                else if (stringPai[i] == 'K' || stringPai[i] == 'k')
                    sanpai[i] = 13;
                else if (stringPai[i] == 'Q' || stringPai[i] == 'q')
                    sanpai[i] = 12;
                else if (stringPai[i] == 'a' || stringPai[i] == 'A')
                    sanpai[i] = 14;
                else
                    sanpai[i] = Integer.parseInt("" + stringPai[i]);
            }
            return sanpai;
        }

        private void setRank() {
            if (sanpai[0] == sanpai[1] && sanpai[0] == sanpai[2])
                rank = BAO;
            else if (sanpai[0] != sanpai[1] && sanpai[1] != sanpai[2])
                rank = PU;
            else if (sanpai[0] - 1 == sanpai[1] && sanpai[1] - 1 == sanpai[2])
                rank = SHUN;
            else
                rank = DUI;

        }

        public int[] getSanpai() {
            return sanpai;
        }

        public int getRank() {
            return rank;

        };

        private void SortPai() {
            for (int i = 0; i < sanpai.length; i++)
                for (int j = i + 1; j < sanpai.length; j++) {
                    if (sanpai[i] < sanpai[j]) {
                        sanpai[i] = sanpai[i] ^ sanpai[j];
                        sanpai[j] = sanpai[i] ^ sanpai[j];
                        sanpai[i] = sanpai[i] ^ sanpai[j];
                    }
                }

        };

        @Override
		public int compareTo(pai o) {
            if (this.getRank() > o.getRank())
                return 1;
            else if (this.getRank() < o.getRank())
                return -1;
            else
                for (int i = 0; i < sanpai.length; i++) {
                    if (sanpai[i] > o.getSanpai()[i])
                        return 1;
                    else if (sanpai[i] < o.getSanpai()[i])
                        return -1;
                }
            // if()
            return 0;
        }
    }

}