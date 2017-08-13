/**
 *
 */
/**
 * @author Administrator
 *
 */
package Õ∂¿∫”Œœ∑;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int end = -1;
            int p = in.nextInt();
            int n = in.nextInt();
            int[] x = new int[n];
            for(int i = 0;i < n;i++){
                x[i] = in.nextInt();
            }
            int[] judge = new int[p];

            for(int i = 0;i < n;i++){
                if(judge[x[i] % p] == 1){
                    end = i + 1;
                    break;
                }
                else
                judge[x[i] % p] = 1;

            }
                System.out.println(end);
            }
        }
    }