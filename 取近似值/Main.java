package È¡½üËÆÖµ;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            float input = scanner.nextFloat();
            System.out.println(floatToNearInt(input));
        }

        scanner.close();
    }

    private static int floatToNearInt(float f) {
        return (int) ((f*10 + 5)/10);
    }
}
