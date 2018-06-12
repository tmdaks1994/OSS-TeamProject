package Compress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//lzw알고리즘 최종본 

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
	 
	 //인코딩
	 public static List<Integer> compress(String uncompressed) {
        // Build the dictionary.
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
                // Add wc to the dictionary.
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }

        if (!w.equals(""))
            result.add(dictionary.get(w));
        return result;
    }
 
    /** Decompress a list of output ks to a string. */
	 //디코딩
    public static String decompress(List<Integer> compressed) {
        // Build the dictionary.
    	Map<Integer,String> dictionary = new HashMap<Integer,String>();
    	dictionary.clear();
    	dictSize = 256;
        
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char)i);
 
        String w = "" + (char)(int)compressed.remove(0);
        StringBuffer result = new StringBuffer(w);
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k == dictSize)
                entry = w + w.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed k: " + k);
 
            result.append(entry);
 
            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));
 
            w = entry;
        }
        return result.toString();
    }
 
    public static void main(String args) {
    	startTime =System.currentTimeMillis();
    	// TODO Auto-generated method stub
   	 int decision = 1;
   	
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
    	//연속된 문자열들에 대한 표를 만들고 다음에 같은 문자열이 발견되면 이표를 참조하는 압축 기법이다.
		//compressed.clear();
	//	dictSize=0;
		//result.clear();
	//	dictionarys.clear();
		
    	compressed = compress(str);
       // System.out.println(compressed);
       // System.out.println(compressed.size());
       // String decompressed = 
    //   resultdecom=  decompress(compressed);

        // System.out.println(decompressed);
       endTime = System.currentTimeMillis()-startTime;
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