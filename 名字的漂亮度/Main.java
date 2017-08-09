package ���ֵ�Ư����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>();
            while ((--n) >= 0) {
                list.add(scanner.next());
            }
            System.out.print(count(list));
        }

        scanner.close();
    }

    /**
     * �����ַ�����������Ư���ȣ����㷽ʽΪ���ַ��������ְ�����Ƶ�ʵĵ�����������ߵĸ�26����һ����25���Դ�����
     *
     * @param list
     * @return
     */
    private static String count(List<String> list) {


        StringBuilder builder = new StringBuilder();

        for (String s : list) {
            int result = 0;
            int[] seq = new int[26];

            // ͳ��ÿ����ĸ���ֵĴ����������ִ�Сд
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // �����Сд
                if (c >= 'a' && c <= 'z') {
                    seq[c - 'a']++;
                }
                // ��д
                else {
                    seq[c - 'A']++;
                }
            }

            // �����ֵĴ����С��������
            Arrays.sort(seq);

            // �������Ư���̶�
            for (int i = 0; i < seq.length; i++) {
                result += seq[i] * (i + 1);
            }


            builder.append(result).append('\n');
        }

        return builder.toString();
    }
}

