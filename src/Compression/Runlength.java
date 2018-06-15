package Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Runlength {
	static String enrunlength;
	static String derunlength;
	static FileReader read;
	static String str;
	static long startTime;
    static long endTime;
    
    public static void main(String args) {
        // TODO Auto-generated method stub
    	startTime =System.currentTimeMillis();
   
    	  str = "";
 		int data = 0;
 		try {
 			if (args == null)
 				return;
 			read = new FileReader(args); //이거는 텍스트 파일만 읽어올수 있는 것
 			//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args),"euc-kr"));
 //이거는 그림, 오디오 , 비디오텍스트등을 파일을 읽어 오는 것.
 			while (true) {
 				try {
 					data = read.read();
 					//strr=reader.readLine();
 					if (data == -1)
 						break;
 					else {
 						char data1 = (char) data;
 						str = str + data1;
 					}
 					if (str.length() == 10000)
 						break;
 				} catch (IOException e1) {
 					e1.printStackTrace();
 				}
 			}
 		} catch (FileNotFoundException e1) {
 			e1.printStackTrace();
 		} 

		enrunlength=lengthencoding(str); //인코딩
		
		endTime = System.currentTimeMillis()-startTime;
	}
    
    //인코딩
public static String lengthencoding(String src) {
		StringBuilder dest = new StringBuilder();
		
		for (int i = 0; i < src.length(); i++) {
			dest.append(src.charAt(i));
			int cnt = 1;
			while (i + 1 < src.length() && src.charAt(i) == src.charAt(i + 1)) { // fixed order
				i++;
				cnt++;
			}
			dest.append(cnt);
		}
		return dest.toString();
		}
		
		//디코딩
public static String lengthdecoding(String desrc) {
			
	StringBuilder dest2 = new StringBuilder();
	for (int i = 0; i < desrc.length() - 1; i = i + 2) {
		char charAt = desrc.charAt(i);
		int cnt = desrc.charAt(i + 1) - '0';
		for (int j = 0; j < cnt; j++) {
			dest2.append(charAt);
		}
	}
return dest2.toString();
//ss456ss2211;;4
	//s2415161s22212;241 예시
	}
		
		public static String getenrunlength() {
			return enrunlength;
		}
		public static long getenrunlengthSIZE() {
			return enrunlength.length();
		}
		public static double runlengthcompressionrate() {
			double compressionrate= 100-(getenrunlengthSIZE()*100/str.length());
			return compressionrate;
		}
		public static long getTime() {
			return endTime;
		}
}
