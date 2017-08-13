/**
 *
 */
/**
 * @author Administrator
 *
 */
package 重复词;


import java.util.ArrayList;



  /*  * 简单做一下说明，根据题意我们知道，重复词相当于将字符串拆分，并且后面部分是前面部分的前缀，  *
    * 才能构成重复词 比如： a b c d a b 就可以切分为  a b c d | a b    *   *
              a b c d | a b c d   *   *
  不难看出，任何一个重复词的形成，一定以字符串首字符进行划分的，比如上个例子中的a，如果划分线 |之后的是其他字符，  *
   *  如 a b c d a | b   *   *   a b c d a | a b c d a
  前缀的匹配一定是失败的。  *    *
  那么这样就有了一个思路，遍历一次字符串，找出所有出现首字符的位置（不包括第一个字符本身），  *    *
  因为划分线靠后，得到的重复词也就越长，所以我选择的是从后向前遍历。   *    *  对于每一个出现首字符的位置
  i，从第一个字符到第 i-1 个字符，  *    *  就是从第一个字符到第 i 个字符的重复词，  *
    *  比如还是刚才的例子 a b c d a b这个字符串的前缀 a b c d a 可以划分为 a b c d | a
  划分线前的部分就是这个字符串的重复词   *    *  这样我们知道 原字符串 a b c d a b 的一个前缀 a b
  c d a 的最大重复词长度为4，把4记录下来，（我是放在了数组里）   *    *  同理，继续比较 i
  的下一个字符与第二个字符是否相等，如果相等，说明从第一个字符到第 i+1个字符也能与之前的重复词匹配 ...  *
   *  依次类推 直到某一个字符匹配失败了，那么后续都不能匹配了，直接跳出循环（对应字符串的重复词相当于未找到）



   * 但是匹配一次未找到是不是意味着该字符串就没有重复词存在呢，这也未必，看下面例子   *  * a b c d
  g... a b c d e f  a b c d g...a b c d e f ，  *
   * 以最后一个a为标准时，后面的b c d 都可以匹配成功，但是 e,f没有匹配成功，第一次就为0，  *
   * 然后以倒数第二个a 为标准时，e ,f 才匹配成功，所以这是个不断更新的过程 ，  *
   * 对于任何一个字符m，以第一个字符开头，m 结尾的字符串如果存在重复词，那么必然存在一个与首字符相同的a ，  *
   * 使得从首字符和a开始匹配，能够一直匹配到m，这就保证了更新的完备性   *  * 更新时
  如果填入的数比原来的数大就填，否则忽略   *  * 最后把结果加起来就行了  * */



  public class Periods {
      public long getLongest(int n,String s){
          if(n==1){return 0;}
          char[] list= s.toCharArray();
          ArrayList<Integer> capital= new ArrayList<Integer>();
          for(int i=n-1;i>0;i--){
              if(list[i] == list[0]){
      capital.add(i);         }    }      /*
    for(int i=0;i<capital.size();i++){
     System.out.println("capital["+i+"] =
  "+capital.get(i));           }*/
          long sum =0;
          int[] arr = new int[n];
          for(int j=0;j<capital.size();j++){



      for(int i=capital.get(j),k=0;i<n;i++,k++){
       if(list[k]==list[i]){
           arr[i] =
  (arr[i]>capital.get(j))?arr[i]:capital.get(j);
       }
          else{
              break;      }
      }     /*     for(int i=0;i<n;i++){
       System.out.println("arr["+i+"]=
  "+arr[i]);     }     */     }
    for(int i=0;i<n;i++){
        sum+=arr[i];   }
       return sum;



    }   }