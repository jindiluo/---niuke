package Í¼Æ¬ÕûÀí_¿ìÅÅ;


import java.util.ArrayList;

import java.util.Collections;


public class Main3 {
	public static void main(){
		 String input = new String("hello");
		 System.out.println(input);
		 char[] cr=input.toCharArray();
	     System.out.println(cr.length);
	     ArrayList<Character> list=new ArrayList<Character>();
	     for(int i=0;i<cr.length;i++){
	    	 list.add(cr[i]);
	     }
	    
	   Collections.sort(list);
	   System.out.println(list.size());
	   for(int i=0;i<list.size();i++){
	  	 System.out.println(list.get(i));
	   }
	    
}
}

