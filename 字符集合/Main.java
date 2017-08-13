/**
 *
 */
/**
 * @author Administrator
 *
 */
package ×Ö·û¼¯ºÏ;
import java.util.HashSet;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
         while(scanner.hasNext()){
        char[] cr=scanner.next().toCharArray();
        HashSet set=new HashSet();
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<cr.length;i++){

            if(set.add(cr[i])){
                buffer.append(cr[i]);


            }

        }
        System.out.println(buffer.toString());
    }
    }

           }
