package 字符串最后一个单词长度001;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 是否还有其它的行，一次可以测试多行
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            System.out.println(arr[arr.length-1].length());


        }

        scanner.close();
    }


}
