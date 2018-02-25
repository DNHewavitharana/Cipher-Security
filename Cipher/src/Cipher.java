import java.util.ArrayList;
import java.util.Scanner;

public class Cipher {
	

	public static ArrayList textarray= new ArrayList();
	
	public static ArrayList permutationarray= new ArrayList();

	public static Encrypt message=new Encrypt();
	public static Decrypt decryptObj=new Decrypt();

	public static Cipher cipherObj=new Cipher();
	
	public static int extrawords;
	public static int[] key= {0,1,2,3};
	public static int countx;

	public static void main(String[] args) {
		//System.out.print("Enter the message : ");
		FileHandler read_obj= new FileHandler();
		
		String readerValue = read_obj.readFile("Input_file.txt");
		
		System.out.println(readerValue);
		System.out.print("Enter the key : ");
		
		Scanner keyReader=new Scanner(System.in);
		String keyValue= keyReader.nextLine();
		keysetter(keyValue);
		
		extrawords = readerValue.length()%4;
		while (readerValue.length()%4>0){
			readerValue+="X";
			countx+=1;
		}
		
		keysetter(keyValue);
		cipherObj.setter(readerValue);
		
		
		message.substitue(cipherObj.getter(0));
		message.permutation(cipherObj.getter(1));
		message.substitue(cipherObj.getter(2));
		message.permutation(cipherObj.getter(3));
		
		FileHandler write_obj= new FileHandler();
		
		read_obj.writeFile("Encrypt_file.txt", cipherObj.getter(4));
		
		System.out.print("Encrypted : ");
		System.out.println(cipherObj.getter(4));
		
		decryptObj.repermutation(cipherObj.getter(4));
		decryptObj.resubstitue(cipherObj.getter(5), countx);
		decryptObj.repermutation(cipherObj.getter(6));
		decryptObj.resubstitue(cipherObj.getter(7), countx);
		
		System.out.println();
		System.out.println();
		
		System.out.print("Encrypted : ");
		System.out.println(cipherObj.getter(4));
		System.out.println();
		

		System.out.print("Decrypted : ");
		System.out.println(cipherObj.getter(8));
	}
	
	public void setter(String msg){
		textarray.add(msg);
		System.out.println(textarray);
	}
	public String getter(int index){
		//System.out.println( textarray.get(index));
		return (String) textarray.get(index);
	}
	
	public void per_setter(String msg){
		permutationarray.add(msg);
		System.out.println(permutationarray);
	}
	public String per_getter(int index){
		//System.out.println( permutationarray.get(index));
		return (String) permutationarray.get(index);
	}
	public int[] keygetter(){
		return key;
	}
	public static void  keysetter(String keyValue){
		for (int v=0; v<keyValue.length();v++){
			String ch=keyValue.substring(v, v+1);
			int num=Integer.parseInt(ch);
			key[v]=num;
		}
	}
	
}
