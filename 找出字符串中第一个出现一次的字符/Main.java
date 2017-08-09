package �ҳ��ַ����е�һ������һ�ε��ַ�;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(findFirst(input));
        }

        scanner.close();
    }

    private static char findFirst(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ����Ѿ����ֹ��ͱ��Ϊ��Ч
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                // ��ǵ�һ�γ��ֵ��±�
                map.put(c, i);
            }
        }


        Collection<Integer> set = map.values();
        int min = Integer.MAX_VALUE;
        // ����С���±�
        for (int i : set) {
            if (min > i) {
                min = i;
            }
        }

        return min == Integer.MAX_VALUE ? '.' : s.charAt(min);
    }
}

