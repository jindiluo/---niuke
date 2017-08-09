package ÆûË®Æ¿;



public class Main2 {
	public static void main(String[] args) {
		
		String cTmp="B";
		int iTmp = Integer.parseInt(cTmp, 16);
        String sTmp = Integer.toBinaryString(iTmp);
        StringBuffer sbTmp = new StringBuffer();
        int j=0;
        for (j = sTmp.length(); j < 4; j++) {
            sbTmp.append("0");
        }
        sbTmp.append(sTmp);
        System.out.print(Integer.toHexString(Integer.parseInt(sbTmp.reverse().toString(), 2)).toUpperCase());
    }

}
