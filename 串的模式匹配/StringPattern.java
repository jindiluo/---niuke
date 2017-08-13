/**
 *
 */
/**
 * @author Administrator
 *
 */
package 串的模式匹配;


//KMP匹配算法
public class StringPattern {
public int findAppearance(String A, int lena, String B, int
lenb) {
//write code here
return kmp(A,lena,B,lenb);
}
public int kmp(String A,int lena,String B,int lenb){
if(A==null||B==null||lena==0||lenb==0)
return -1;
int[] next = new int[lenb];
makenext(B,next);
int j = 0;
for(int i=0;i<lena;i++){
while(j>0&&A.charAt(i)!=B.charAt(j))
j = next[j-1];
if(A.charAt(i)==B.charAt(j))
j++;
if(j==lenb)
return i-j+1;
}
return -1;
}
public void makenext(String B,int[] next){
 //创建next表
next[0] = 0;
int j = 0;
for(int i=1;i<B.length();i++){
while(j>0&&B.charAt(i)!=B.charAt(j))
j = next[j-1];
if(B.charAt(i)==B.charAt(j))
j++;
next[i] = j;
}
}
}