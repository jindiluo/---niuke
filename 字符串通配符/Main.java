package 字符串通配符;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner reader=new Scanner(System.in);
        while(reader.hasNext()){
            String data1=reader.next();
            String data2=reader.next();
            boolean res=false;
            res=check(data1,data2,0,0);
            System.out.println(res);
        }
    }
    public static boolean check(String data1,String data2,int i,int j){
        //if(i)
        /**if((i!=data1.length()&&j==data2.length())||(i==data1.length()&&j!=data2.length())){

        }*/

        /**if(i==data1.length()&&j==data2.length()){
            return true;
        }
        else{
            boolean res=false;
            if(data1.charAt(i)==data2.charAt(j)){
                res=check(data1,data2,i+1,j+1);
            }
            else{
                if(data1.charAt(i)=='?'){
                    if((data2.charAt(j)>='0'&&data2.charAt(j)<='9')||(data2.charAt(j)>='A'&&data2.charAt(j)<='Z')||//这一点也很重要
                            (data2.charAt(j)>='a'&&data2.charAt(j)<='z')){
                        res=check(data1,data2,i+1,j+1);
                    }
                    else{
                        return false;
                    }
                }
                else if(data1.charAt(i)=='*'){
                    //for(int k=j)
                    for(;j<data2.length();j++){
                        res=check(data1,data2,i+1,j);
                        if(res){
                            break;
                        }
                    }
                }
                else{
                    return false;
                }
                //return
            }
            return res;
        }*/
        if(i==data1.length()){
            return true;
        }
        else{
            boolean res=false;
            if(data1.charAt(i)=='?'){
                if(j<data1.length()&&(data2.charAt(j)>='0'&&data2.charAt(j)<='9')||(data2.charAt(j)>='A'&&data2.charAt(j)<='Z')||//这一点也很重要
                            (data2.charAt(j)>='a'&&data2.charAt(j)<='z')){
                    res=check(data1,data2,i+1,j+1);
                }
                else{
                    return false;
                }
            }
            else if(data1.charAt(i)=='*'){
                if(j==data2.length()){
                    //return true;
                    res=check(data1,data2,i+1,j);                    //这个地方很特别
                }
                else{
                    for(;j<data2.length();j++){
                        res=check(data1,data2,i+1,j);
                        if(res){
                            break;
                        }
                    }
                }
            }
            else{//这一部分不能漏
                if(j<data2.length()&&data1.charAt(i)==data2.charAt(j)){
                    res=check(data1,data2,i+1,j+1);
                }
                else{
                    return false;
                }
            }
            return res;
        }
    }
}