/**
 *
 */
/**
 * @author Administrator
 *
 */
package allsequenceofString;



//import java.io.*;
 public class test
{
	 public static void main (String[] args) throws java.lang.Exception
	    {
	        traversalSubstrings("THETXH");
	    }

	    public static void traversalSubstrings(String s) {
	        int len = s.length();
	        int start = (1<<len) - 1;
	        int end = (1<<len + 1) -1;
	        for(int i = start;i < end;i ++) {
	          System.out.println(treeIndex2Substring(s, i));
	        	String tmp=treeIndex2Substring(s, i);
	        	if(tmp.length()>=4){

		        	if(tmp.substring(0,2).equals(tmp.substring(2,4))){
		        		System.out.println("faulse");
		        	}

		        }
	        }
	        return;
	    }

	    public static String treeIndex2Substring(String s, int index) {
	        StringBuilder sb = new StringBuilder();
	        int srcIndex = 0;
	        while(index >0) {
	            if(index % 2 != 0) {
	                //奇数，表示存在当前字符
	                sb.append(s.charAt(srcIndex ++));
	            }
	            else {
	                //偶数，表示不存在当前字符
	                srcIndex ++;
	            }
	            index = (index - 1)/2;
	        }




	        return sb.toString();
	    }






}