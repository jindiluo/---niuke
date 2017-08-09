package 迷宫问题;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
   public static void main(String [] args)
       {
      Scanner sc=new Scanner(System.in);

       while(sc.hasNext())
      {
          int hang=sc.nextInt();
          int lie=sc.nextInt();
           int [][]arr=new int[hang][lie];
           for(int i=0;i<hang;i++)
           {
               for(int j=0;j<lie;j++)
               {
                  arr[i][j]=sc.nextInt();

               }
           }
           int[][]dir=new int[2][2];
           dir[0]=new int[]{0,1};  //向右走
           dir[1]=new int[]{1,0};   //向下走。
           List<List<int[]>> res=new ArrayList<List<int[]>>();
           List<int[]> ls=new ArrayList<>();
           ls.add(new int[]{0,0});
           dfs(res,ls,arr,0,0,hang,lie,dir);
           ls=res.get(0);
           for(int i=0;i<ls.size();i++)
              System.out.println("("+ls.get(i)[0]+","+ls.get(i)[1]+")");

      }
   }
  public static void dfs(List<List<int[]>> res,List<int []> ls,int [][]arr,int x,int y,int hang,int lie,int[][]dir)
   {
       if( x>=hang ||y>=lie||arr[x][y]==1)
           return;
       if(x==(hang-1) && y==(lie-1))
       {
           res.add(new ArrayList<>(ls));
           return ;
       }
       for(int i=0;i<2;i++)
       {
           int[] tmp=new int[]{x+dir[i][0],y+dir[i][1]};
           ls.add(tmp);
           dfs(res,ls,arr,x+dir[i][0],y+dir[i][1],hang,lie,dir);
           ls.remove(ls.size()-1);
       }
   }
}
