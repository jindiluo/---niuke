package �ַ������һ�����ʳ���001;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // �Ƿ����������У�һ�ο��Բ��Զ���
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            System.out.println(arr[arr.length-1].length());


        }

        scanner.close();
    }


}
