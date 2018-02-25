import java.util.ArrayList;

public class Encrypt {
	public static String encryptText;
	public static Decrypt en_message=new Decrypt();
	public Cipher cipherObject=new Cipher();
	
	public void substitue(String message){
		encryptText="";
		for (int i=0;i<message.length();i++){
			int ascii = (int) message.charAt(i)+ (message.length()-i);
			
			String newtext= Character.toString ((char) ascii);
			
			encryptText += newtext;
		}
		
		cipherObject.setter(encryptText);
		
		System.out.println(encryptText);
		
	}
	
	public void permutation(String msg){
		
		int[] code =cipherObject.keygetter();
		String permutateResult="";
		while (msg.length()>0){
			String permutText="";
			String tempStr= (String) msg.subSequence(0, 4);
			for (int i=0; i<code.length; i++){
				permutText += tempStr.charAt(code[i]);
			}
			permutateResult += permutText;
		
			System.out.println(permutText);
			//System.out.println(permutateResult);
			
			msg=msg.substring(4);
		
		}
		cipherObject.setter(permutateResult);

	}
}
