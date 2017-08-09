package 学英语;
import java.util.Scanner;


public class Main {

    private final static String WORDS[] = {
            "", "one", "two", "three", "four", "five",// 1-5
            "six", "seven", "eight", "nine", "ten",// 6-10
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",// 11-15
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty",// 16-20
            "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"// 30-90
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNextLong()) {
            long num = scanner.nextLong();
            System.out.println(parse(num));
        }
        scanner.close();
    }

    private static String parse(long num) {
        if (num <= 0) {
            return "error";
        } else if (num < 20) {  // 20娴犮儰绗�
            return WORDS[(int) num];
        } else if (num < 100) {
            if (num % 10 == 0) {
                return WORDS[(int) (20 + (num - 20) / 10)];     // 20 30 40 50 60 70 80 90
            } else {
                return parse(num / 10 * 10) + " " + parse(num % 10);
            }
        } else if (num < 1_000) { // 閸楀啩浜掓稉锟�
            if (num % 100 == 0) {
                return parse(num / 100) + " hundred";
            } else {
                return parse(num / 100) + " hundred and " + parse(num % 100);
            }
        } else if (num < 1_000_000) { // 閻у彞绔炬禒銉ょ瑓
            if (num % 1_000 == 0) {
                return parse(num / 1_000) + " thousand";
            } else {
                return parse(num / 1_000) + " thousand " + parse(num % 1_000);
            }
        } else if (num < 1_000_000_000) { // 娴滐拷
            if (num % 1_000_000 == 0) {
                return parse(num / 1_000_000) + " million";
            } else {
                return parse(num / 1_000_000) + " million " + parse(num % 1_000_000);
            }
        } else if (num < 10_000_000_000L) { // 閸椾椒鍤�
            if (num % 1_000_000_000 == 0) {
                return parse(num / 1_000_000_000) + " billion";
            } else {
                return parse(num / 1_000_000_000) + " billion " + parse(num % 1_000_000_000);
            }
        } else {
            return "error";
        }
    }
}
