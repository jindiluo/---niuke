package ��������;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(argAnalysis(input));
        }

        scanner.close();
    }

    /**
     * ��������������������һ�ַ���������ֱ�����������������ɼ���ʱ�临�ӶȺͿռ临�Ӷȣ������������鷳һЩ��
     * @param s
     * @return
     */
    private static String argAnalysis(String s) {

        List<String> list = new ArrayList<>();

        // ��ʾ���һ��"���ֵ���һ��λ�ã����û��"��Ϊ0
        int prev = 0;
        for (int i = 0; i < s.length(); ) {
            // i��ʼ�ĵ�һ��˫����
            if (s.charAt(i) == '"') {
                // ��Ӳ���˫���ŵ��ַ���
                list.add(s.substring(prev, i));

                for (int j = i + 1; j < s.length(); j++) {
                    // ��ʼ�ĵڶ���˫����
                    if (s.charAt(j) == '"') {
                        list.add(s.substring(i, j + 1));

                        i = j + 1;
                        prev = i;
                    }
                }
            } else {
                i++;
            }
        }

        // ��1��
//        // ��ʾû��"
//        if (prev == 0) {
//            list.add(s);
//        }
//        // �������һ��û��
//        else if (prev < s.length()) {
//            list.add(s.substring(prev, s.length()));
//        }

        // ��2������1����2��ʵ��ͬ����Ч��
        if (prev < s.length()) {
            list.add(s.substring(prev, s.length()));
        }

        // ���洦��ո�˫����������ַ�����������
        int result = 0;
        StringBuilder builder = new StringBuilder();
        for (String t : list) {
            // �������"��ʼ
            if (!t.startsWith("\"")) {
                String[] sts = t.split("\\s+");
                result += sts.length;
                for (String st : sts) {
                    builder.append(st).append('\n');
                }
            } else {
                result++;
                builder.append(t).append('\n');
            }
        }

        return result + "\n" + builder.substring(0, builder.length() - 1);
    }
}

