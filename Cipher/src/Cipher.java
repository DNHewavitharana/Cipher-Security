import java.util.ArrayList;
import java.util.Scanner;

public class Cipher {
	public static ArrayList textarray= new ArrayList();
	
	public static ArrayList permutationarray= new ArrayList();

	public static Encrypt message=new Encrypt();
	public static Decrypt decryptObj=new Decrypt();

	public static Cipher cipherObj=new Cipher();
	
	public static int extrawords;
	public static int[] key;

	public static void main(String[] args) {
		System.out.print("Enter the message : ");
		
		Scanner inputReader=new Scanner(System.in);
		String readerValue= inputReader.nextLine();
		
		System.out.print("Enter the key : ");
		
		Scanner keyReader=new Scanner(System.in);
		String keyValue= keyReader.nextLine();
		
		
		
		extrawords = readerValue.length()%4;
		while (readerValue.length()%4>0){
			readerValue+="X";
		}
		
		cipherObj.setter(readerValue);
		
		
		message.substitue(cipherObj.getter(0));
		message.substitue(cipherObj.getter(1));
		message.permutation(cipherObj.getter(1));
		message.permutation(cipherObj.per_getter(0));
		
		decryptObj.repermutation(cipherObj.per_getter(1));
		decryptObj.repermutation(cipherObj.per_getter(0));
		decryptObj.resubstitue(cipherObj.getter(1));
		decryptObj.resubstitue(cipherObj.getter(1));
		
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
}
