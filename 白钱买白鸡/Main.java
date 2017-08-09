package ��Ǯ��׼�;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            scanner.nextLine();
            System.out.print(getResult());
        }

        scanner.close();
    }

    /**
     * ���̣�x������ĸ��y����������z���������� 100 = 5x + 3y+ z/3 �� 100 = x + y + z�����п��ܽ�
     *
     * @return
     */
    public static String getResult() {
        StringBuilder builder = new StringBuilder();

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100 - x; y++) {
                int z = 100 - x - y;
                if (z % 3 == 0 && 100 == 5 * x + 3 * y + z / 3) {
                    builder.append(x).append(' ').append(y).append(' ').append(z).append('\n');
                }
            }
        }

        return builder.toString();
    }
}

