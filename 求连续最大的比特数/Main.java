package 求连续最大的比特数;
import java.util.Scanner;
public class Main{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            System.out.println(getNums(a));
        }
    }

    private static int getNums(int a){
        if(a==0)    return 0;
        String str=Integer.toBinaryString(a);
        int count=0;
        int max=0;
        for(int i=0;i+1<str.length();i++){
            if(str.charAt(i)=='1'&&str.charAt(i)==str.charAt(i+1)){
                 count++;
                if(count>max){
                    max=count;
                }
            }
            else{
                count=0;
            }
        }
        return max+1;
    }
}