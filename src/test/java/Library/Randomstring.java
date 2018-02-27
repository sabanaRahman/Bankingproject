package Library;

import java.util.Random;

public class Randomstring {
	
	public static void main(String[] args) {
		
	
	}
	
	
	public static String generaterandomString() {
	
		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		String randomString="";
		int length=4;
	 
	 Random rand=new Random();
	 
	char[] str= new char[4];
	
	for(int i=0;i<4;i++)
	 {
		 str[i]=characters.charAt(rand.nextInt(characters.length()));
	 }
	
	for(int i=0;i<str.length;i++)
	{
		
		//char randomString1=str[i];
		randomString=randomString+str[i];
		
		
	}
	
	return randomString;
	}





}
