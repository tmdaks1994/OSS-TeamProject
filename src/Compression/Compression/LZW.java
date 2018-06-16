package Compression;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//lzw�˰��� ������ 

public class LZW {
    /** Compress a string to a list of output symbols. */
	 static List<Integer> result = new ArrayList<Integer>();
	 static Map<String,Integer> dictionary = new HashMap<String,Integer>();
	 
	 static FileReader read;
	 static String resultdecom;
	 static List<Integer> compressed;
	 static int dictSize;
	 static String str;
	 static long startTime;
	 static long endTime;
	    
	 public static void main(String args) {
	    	startTime =System.currentTimeMillis();
	    	// TODO Auto-generated method stub
	   	
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
			
	    	compressed = compress(str);
	
	       endTime = System.currentTimeMillis()-startTime;
	    }
	    	 
	 //���ڵ�
	 public static List<Integer> compress(String uncompressed) {
        // 0~255���� ���̺� �������� Ű���忡 �ִ� ������ ���� �ִ´�.
		 result.clear();
		 dictionary.clear();
		 
         dictSize = 256;
        
        for (int i = 0; i < 256; i++)
            dictionary.put("" + (char)i, i);
 
        String w = "";
       
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc))
                w = wc;
            else {
                result.add(dictionary.get(w));
                // �߰��Ѱ� ����ֱ� 
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }

        if (!w.equals(""))
            result.add(dictionary.get(w));
        return result;
    }
 
    /** Decompress a list of output ks to a string. */
	 //���ڵ�
    public static String decompress(List<Integer> decompressed) {

    	Map<Integer,String> dictionary = new HashMap<Integer,String>();
    	dictionary.clear();
    	
    	
    	dictSize = 256;
        
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char)i);
 
        String w = "" + (char)(int)decompressed.remove(0);
        StringBuffer result = new StringBuffer(w);
        for (int k : decompressed) {
            String entry;
            if (dictionary.containsKey(k)) {
                entry = dictionary.get(k);
            }
            else if (k == dictSize)
            {   entry = w + w.charAt(0);
            }else
                throw new IllegalArgumentException("Bad compressed k: ");
 
            result.append(entry);
 
            dictionary.put(dictSize++, w + entry.charAt(0));
 
            w = entry;
        }
        return result.toString();
    }
 

    public static  Map<String,Integer> resultcom(){
    	
    	return dictionary;
    }
    
    public static List<Integer> comresult(){
    	return result;
    }
    
    public static String lzwdecompressed() {
    return  resultdecom;
    }

    public static long lzwsize() {
	return result.size();
}
    
    public static double lzwcompressrate() {
    	double lzwcompress= 100-(lzwsize()*100/str.length());
    	return lzwcompress;
    }
	public static double lzwTime() {
		return endTime;
	}
}