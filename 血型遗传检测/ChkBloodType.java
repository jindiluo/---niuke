/**
 *
 */
/**
 * @author Administrator
 *
 */
package 血型遗传检测;

//按照基因规律来做。
//TreeSet本来就是按字母顺序的。数字字母可以不用写比较器
import java.util.TreeSet;

public class ChkBloodType {
  public String[] chkBlood(String father, String mother) {
      // write code here
      String[] gF = new String[2];
      if(father.equals("A")){
          gF[0]="A";
          gF[1]="i";
      }else if(father.equals("B")){
          gF[0]="B";
          gF[1]="i";
      }else if(father.equals("AB")){
          gF[0]="A";
          gF[1]="B";
      }else if(father.equals("O")){
          gF[0]="i";
          gF[1]="i";
      }
      String[] gM = new String[2];
      if(mother.equals("A")){
          gM[0]="A";
          gM[1]="i";
      }else if(mother.equals("B")){
          gM[0]="B";
          gM[1]="i";
      }else if(mother.equals("AB")){
          gM[0]="A";
          gM[1]="B";
      }else if(mother.equals("O")){
          gM[0]="i";
          gM[1]="i";
      }
      TreeSet<String> child = new TreeSet<String>();
      for(int i=0;i<2;i++){
          for(int j=0;j<2;j++){
              child.add(gF[i]+gM[j]);
          }
      }

      //返回数组
      TreeSet<String> set =new TreeSet<String>();
      for(String s : child){
          if(s.equals("Ai") || s.equals("iA") || s.equals("AA")){
              set.add("A");
          }else if(s.equals("Bi") || s.equals("iB") || s.equals("BB")){
              set.add("B");
          }else if(s.equals("AB") || s.equals("BA")){
              set.add("AB");
          }else if(s.equals("ii")){
              set.add("O");
          }
      }
      String[] res = new String[set.size()];
      res = set.toArray(res);
      return res;
  }
}
