
package Test;
 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class length {
	
	static String s = new String();
	static String encod;
//	static String d;
	static String text = "";
	static String[] splitedStr;
	
	@SuppressWarnings("unused")
	public static void Start(String args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args));
			while(true)
			{
				
				try 
				{
					splitedStr = s.split(" ");
					s = br.readLine();
					if(s == null) break;
					text=s;
					
					encod = encode();
				        decode();
				
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
 
	static String encode() {
		StringBuffer stringBuffer = new StringBuffer();
		
		splitedStr = null;
		   
		splitedStr = text.split(" ");
		
		for (int i = 0; i < text.length(); i++) {
			int runLength = 1;
			
			while (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
				runLength++;
				i++;
			}
 
			stringBuffer.append(runLength); // AAA -> 3
			stringBuffer.append(text.charAt(i)); // A
			
		}
		
		return stringBuffer.toString();
	}
 
	static String decode() {
		StringBuffer stringBuffer = new StringBuffer();
		
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(encod);
 
		while (matcher.find()) {
			int num = Integer.parseInt(matcher.group());
			matcher.find();
			while (num-- != 0) {
				stringBuffer.append(matcher.group());
			}
		}
		
 
		return stringBuffer.toString();
	}
}

 