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
 			read = new FileReader(args); //�̰Ŵ� �ؽ�Ʈ ���ϸ� �о�ü� �ִ� ��
 			//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args),"euc-kr"));
 //�̰Ŵ� �׸�, ����� , �����ؽ�Ʈ���� ������ �о� ���� ��.
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

		enrunlength=lengthencoding(str); //���ڵ�
		
		endTime = System.currentTimeMillis()-startTime;
	}
    
    //���ڵ�
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
		
		//���ڵ�
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
	//s2415161s22212;241 ����
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
