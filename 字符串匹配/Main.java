package �ַ���ƥ��;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  //      Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String sub = scanner.next();
            String s = scanner.next();
            System.out.println(contains(s, sub));
        }

        scanner.close();
    }

//ע��Ҫ��Set����
    private static boolean contains(String s, String sub) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (int i = 0; i < sub.length(); i++) {
            if (!set.contains(sub.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

