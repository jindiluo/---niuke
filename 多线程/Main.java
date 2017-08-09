package ���߳�;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("ABCD");
            }
            System.out.println();
        }

        scanner.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO Ӧ��ʹ������ķ������в���
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * ��ӡ�߳�
     */
    public static class WriteThread extends Thread {
        // ��ӡ����
        private final int times;
        // �߳�����
        private final String name;
        // ��ӡ˳�����
        private final AtomicInteger order;
        // ��ǰ�̵߳��ر��ʶ
        private final int flag;
        // ���е��߳���
        private final int all;
        // ������
        private final StringBuilder builder;

        public WriteThread(int times, String name, AtomicInteger order, int flag, int all, StringBuilder builder) {
            this.times = times;
            this.name = name;
            this.order = order;
            this.flag = flag;
            this.all = all;
            this.builder = builder;
        }

        @Override
        public void run() {
            int count = 0;
            // һֱ�����ָ������
            while (count < times) {
                // �ж��Ƿ��ֵ��Լ����
                if (order.get() == flag) {
                    // ���������һ
                    count++;
                    // �������
                    builder.append(name);
                    // ָ����һ���߳̽������
                    order.set((flag + 1) % all);
                }
            }
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main2.class.getClassLoader().getResourceAsStream("data.txt"));

        // ��ȡ���������е�����
        List<Integer> input = new LinkedList<>();
        while (scanner.hasNextLong()) {
            input.add(scanner.nextInt());
        }

        // ������
        List<StringBuilder> result = new LinkedList<>();
        for (int num : input) {
            StringBuilder builder = new StringBuilder();
            result.add(builder);
            AtomicInteger order = new AtomicInteger(0);
            WriteThread a = new WriteThread(num, "A", order, 0, 4, builder);
            WriteThread b = new WriteThread(num, "B", order, 1, 4, builder);
            WriteThread c = new WriteThread(num, "C", order, 2, 4, builder);
            WriteThread d = new WriteThread(num, "D", order, 3, 4, builder);
            a.start();
            b.start();
            c.start();
            d.start();
            a.join();
            b.join();
            c.join();
            d.join();

        }

        for (StringBuilder b : result) {
            System.out.println(b);
        }

        scanner.close();
    }
}



