package _24点游戏算法;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            System.out.println(game24Points(a, b, c, d));

        }
        scanner.close();
    }

    // a, b, c, d閮藉湪[1, 10]鍐�

    /**
     * 4涓猍1, 10]鐨勮兘鍚﹂�氳繃鍔犲噺涔橀櫎锛屽緱鍒版暟瀛椾负24
     *
     * @param a 绗竴涓暟瀛�
     * @param b 绗簩涓暟瀛�
     * @param c 绗笁涓暟瀛�
     * @param d 绗洓涓暟瀛�
     * @return true锛屽彲浠ョ粍鎴�24锛宖alse涓嶅彲浠ョ粍鎴�24
     */
    private static boolean game24Points(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d, '+', '-', '*', '/'};
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> list = new LinkedList<Integer>();

        boolean[] rst = {false};

        // 鏋勯�犵粍鍚堢殑閫嗘尝鍏拌〃杈惧紡
        for (int i = 0; i < 4; i++) {
            used[i] = true;
            list.add(arr[i]);
            to24(arr, used, 1, 0, list, rst);

            if (rst[0]) {
                return true;
            }

            // 鐜板満杩樺師
            list.removeLast();
            used[i] = false;
        }


        return false;
    }

    /**
     * 4涓猍1, 10]鐨勮兘鍚﹂�氳繃鍔犲噺涔橀櫎锛屽緱鍒版暟瀛椾负24
     *
     * @param arr    鑳藉浣跨敤鐨勬搷浣滄暟銆佹搷浣滅鐨勬暟缁�
     * @param used   宸茬粡浣跨敤鐨勬搷浣滄暟銆佹搷浣滅鏍囪鏁扮粍
     * @param numCnt 鎿嶄綔鏁扮殑涓暟
     * @param optCnt 鎿嶄綔绗︾殑涓暟
     * @param list   姹傚緱鐨勯�嗘尝鍏板紡
     * @param rst    淇濆瓨涓棿缁撴灉锛屾湁婊¤冻24鐨勫氨鍋滄璁＄畻
     */
    private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt,
                             LinkedList<Integer> list, boolean[] rst) {


        // 濡傛灉宸茬粡鎵惧埌绛旀灏变笉杩涜鎿嶄綔浜�
        if (rst[0]) {
            return;
        }
        // 宸茬粡瀹屾垚浜嗛�嗘尝鍏板紡鐨勬瀯閫�
        if (numCnt > optCnt && numCnt + optCnt == 7) {
            calInversePoland(list, rst);
        }
        // 杩樿鏋勯�犻�嗘尝鍏板紡
        else if (numCnt > optCnt) {

            for (int i = 0; i < arr.length; i++) {
                // 濡傛灉arr[i]杩樻病鏈夎浣跨敤杩囷紝鎴栬�卆rr[i]鏄繍绠楃
                if (!used[i] || arr[i] < 0 || arr[i] > 10) {
                    // 濡傛灉鏄暟瀛�
                    if (arr[i] >= 0 && arr[i] <= 10) {
                        list.add(arr[i]);
                        numCnt++;
                        used[i] = true;

                        to24(arr, used, numCnt, optCnt, list, rst);

                        // 鎵惧埌浜嗕竴涓瓟妗堝氨杩斿洖
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        numCnt--;
                        used[i] = false;

                    }
                    // 濡傛灉鏄搷浣滅锛屽垯鏀惧叆arr[i]涔嬪墠锛屾搷浣滄暟蹇呴』姣旀搷浣滅澶氫袱涓�
                    else if (numCnt + 1 > optCnt) {
                        list.add(arr[i]);
                        optCnt++;
                        used[i] = true;

                        to24(arr, used, numCnt, optCnt, list, rst);

                        // 鎵惧埌浜嗕竴涓瓟妗堝氨杩斿洖
                        if (rst[0]) {
                            return;
                        }
                        list.removeLast();
                        optCnt--;
                        used[i] = false;
                    }
                }
            }

        }


    }

    /**
     * 璁＄畻閫嗘尝鍏板紡鐨勫��
     *
     * @param list 閫嗘尝鍏板紡
     * @param rst  鐢ㄤ簬淇濆瓨璁＄畻缁撴灉
     */
    private static void calInversePoland(LinkedList<Integer> list, boolean[] rst) {
        LinkedList<Double> stack = new LinkedList<>();

        for (int v : list) {

            // 濡傛灉鏄暟瀛�
            if (v >= 0 && v <= 10) {
                stack.add((double)v);
            } else {
                double a = stack.removeLast();
                double b = stack.removeLast();
                double c = 0;
                switch ((char) v) {
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        // 闄ゆ暟涓嶈兘涓�0
                        if (a == 0) {
                            return;
                        }
                        c = b / a;
                        break;
                }

                stack.add(c);
            }
        }



        rst[0] = stack.getFirst() == 24.0;
    }

}
