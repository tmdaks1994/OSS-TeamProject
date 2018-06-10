package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;

public class Runlength {

	static FileReader read;
	static StringBuffer runlength;
    public static void main(String args) {
        // TODO Auto-generated method stub
    	 int decision = 1;
    	
    	 String str = "";
 		StringBuffer str2;
 		int data = 0;
 		String strr;
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
 /*catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
 	
  StringBuffer setStr=new StringBuffer(str);
 		// StringBuffer setStr=getInput(str);
 	   /*StringBuffer orgStr = getInputString();*/
       //작업 및 출력
       System.out.println("압축된 문자열: " + compressString(setStr));
       runlength=compressString(setStr);
     
   }
    	
        //문자열입력
     

    static private StringBuffer compressString(StringBuffer orgStr) {
        for(int i=0; i < orgStr.length(); i++) {
            //현재 문자가 숫자라면 건너띈다.
            if(isString2Int(Character.toString(orgStr.charAt(i))))
                continue;
            //같은문자 count변수, 문자검사 시 이동하는 index변수
            int charCount = 0;
            int curIdx = i;
            //현재 위치(i)부터 다음 문자를 계속 탐색하며 같은 문자라면 charCount++, 다르다면
            while(orgStr.charAt(i) == orgStr.charAt(curIdx)) {
                charCount++;
                curIdx++;
                //문자열의 마지막인지 검사
                if(curIdx > orgStr.length()-1 )
                    break;
            }

            orgStr.replace(i, curIdx, Character.toString(orgStr.charAt(i)) + String.valueOf(charCount));
        }

        return orgStr;
    }

    //int형 수인지 검사
    static private boolean isString2Int(String str) {
        try {
            Integer.parseInt(str);
 
            return true;
        }catch(NumberFormatException e) {

            return false;
        }
    }

   
    static StringBuffer getRunlength() {
    	return runlength;
    }
}
