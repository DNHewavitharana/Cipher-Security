import java.util.ArrayList;
import java.util.Arrays;

public class Decrypt {
	public static String normalText;
	//public static ArrayList<Integer> asciiValue= new ArrayList<Integer>();
	public Cipher cipherObject=new Cipher();
	FileHandler read_obj= new FileHandler();
	
	
	
	public void resubstitue(String message, int countx){
		normalText="";
		for (int i=0;i<message.length();i++){
			int ascii = (int) message.charAt(i)- (message.length()-i);
			
			String newtext= Character.toString ((char) ascii);
			normalText += newtext;
		}
		cipherObject.setter(normalText);
		read_obj.writeFile("Output_file.txt", normalText.substring(0,normalText.length()-countx));
	}
	
	public void repermutation(String msg){
		int[] code =cipherObject.keygetter();
		
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
		cipherObject.setter(permutateResult);
		System.out.println("permutateResult");
		System.out.println(permutateResult);
	}
}
