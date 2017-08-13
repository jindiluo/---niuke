/**
 *
 */
/**
 * @author Administrator
 *
 */
package ���һ���ַ�;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int T = 0;
         // InputStreamReader ���ֽ���ͨ���ַ���������;
         // Ϊ�˴ﵽ���Ч�ʣ���Ҫ������ BufferedReader �ڰ�װ InputStreamReader�����磺
         // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            T = Integer.parseInt(bufferedReader.readLine());
            for(int i=0; i<T; i++){
                String str = bufferedReader.readLine();
                System.out.println(firstAppearsOnlyonce(str));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ���ַ����е�һ��ֻ����һ�ε��ַ�
     */
    private static char firstAppearsOnlyonce(String str) {
        int[] hash = new int[256];                  //��¼ÿ���ַ���Ӧ�ĸ���,����256��ASCII��
        for(int i=0; i<256; i++){
            hash[i] = 0;
        }
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i)] ++;                 //����һ���ַ��������ӳ���ϵ!
        }
        for(int i=0; i<str.length(); i++){           //�ٱ���һ���ַ���,�ҵ�һ������һ���ַ�
            if(hash[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '\0';
    }
}