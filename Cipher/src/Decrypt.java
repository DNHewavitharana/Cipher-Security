import java.util.ArrayList;
import java.util.Arrays;

public class Decrypt {
	public static String normalText;
	//public static ArrayList<Integer> asciiValue= new ArrayList<Integer>();
	public Cipher cipherObject=new Cipher();

	
	public void resubstitue(String message){
		normalText="";
		for (int i=0;i<message.length();i++){
			int ascii = (int) message.charAt(i)- (message.length()-i);
			
			String newtext= Character.toString ((char) ascii);
			normalText += newtext;
		}
		cipherObject.setter(normalText);

		System.out.println(normalText.substring(0,normalText.length()-1-2));
		
	}
	
	public void repermutation(String msg){
		int[] code ={2,1,3,0};
		String permutateResult="";
		while (msg.length()>0){
			String repermutText="";
			String tempStr= (String) msg.subSequence(0, 4);
			
			for (int m=0; m<4; m++){
				for (int k=0; k<code.length; k++){
					 if (m == code[k]){
						repermutText += tempStr.charAt(k);
					 }
				}
			}
			
			permutateResult += repermutText;
			msg=msg.substring(4);
		}
		System.out.println("permutateResult");
		System.out.println(permutateResult);
	}
}
