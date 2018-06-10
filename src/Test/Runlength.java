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
 /*catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
 	
  StringBuffer setStr=new StringBuffer(str);
 		// StringBuffer setStr=getInput(str);
 	   /*StringBuffer orgStr = getInputString();*/
       //�۾� �� ���
       System.out.println("����� ���ڿ�: " + compressString(setStr));
       runlength=compressString(setStr);
     
   }
    	
        //���ڿ��Է�
     

    static private StringBuffer compressString(StringBuffer orgStr) {
        for(int i=0; i < orgStr.length(); i++) {
            //���� ���ڰ� ���ڶ�� �ǳʶ��.
            if(isString2Int(Character.toString(orgStr.charAt(i))))
                continue;
            //�������� count����, ���ڰ˻� �� �̵��ϴ� index����
            int charCount = 0;
            int curIdx = i;
            //���� ��ġ(i)���� ���� ���ڸ� ��� Ž���ϸ� ���� ���ڶ�� charCount++, �ٸ��ٸ�
            while(orgStr.charAt(i) == orgStr.charAt(curIdx)) {
                charCount++;
                curIdx++;
                //���ڿ��� ���������� �˻�
                if(curIdx > orgStr.length()-1 )
                    break;
            }

            orgStr.replace(i, curIdx, Character.toString(orgStr.charAt(i)) + String.valueOf(charCount));
        }

        return orgStr;
    }

    //int�� ������ �˻�
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
