/**
 *
 */
/**
 * @author Administrator
 *
 */
package Spring_outing;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        new Main().process();
    }

    private int N;

    private int K;

    private void process(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            N=sc.nextInt();//N represents number of persons
            K=sc.nextInt();//K represents number of destinaitons
            pArray=new int[N][];
            for(int i=0;i<N;i++){
                pArray[i]=new int[K+1];
                for(int j=0;j<K+1;j++){
                    pArray[i][j]=sc.nextInt();
                }
            }
            voteRecords=new int[K+2];
            for(int i=0;i<=K;i++){voteRecords[i]=-1;}//Initiate recoards
            int dest=vote(1);//Get result
            String result=null;
            if(dest==0) result="otaku";
            else result=dest+"";
            voteRecords=null;//Release memory
            System.out.println(result);
        }
        sc.close();
    }

    private int[] voteRecords;

    private int vote(int dest){
        if(dest==K+1){
            voteRecords[dest]=0;
            return 0;//Stay at home
        }
        if(voteRecords[dest+1]==-1){
            vote(dest+1);
        }
        voteRecords[dest]=voteIn(dest,voteRecords[dest+1]);
        return voteRecords[dest];
    }

    private int[][] pArray;

    private int voteIn(int dest1,int dest2){
        int counter=0;
        for(int i=0;i<N;i++){
            int p1=0,p2=0;
            for(int j=0;j<K+1;j++){
                if(pArray[i][j]==dest1){p1=j;continue;}
                if(pArray[i][j]==dest2){p2=j;continue;}
            }
            if(p1<p2) counter++;
        }
        if(counter>N/2) return dest1;
        else return dest2;
    }
}