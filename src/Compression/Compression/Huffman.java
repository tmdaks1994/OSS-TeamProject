package Compression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Huffman coding , decoding */

public class Huffman {
    static final boolean readFromFile = false;
    static final boolean newTextBasedOnOldOne = false;
static FileReader read;
static File oFile;

    static PriorityQueue<HuffmanNode> nodes = new PriorityQueue<>((o1, o2) -> (o1.value < o2.value) ? -1 : 1);
    static TreeMap<Character, String> codes = new TreeMap<>(); //character 문자 셋
    static String text = "";
    static String encoded = "";
    static String decoded = "";
    static long startTime;
    static long endTime;
    
    public static void main(String args) throws FileNotFoundException {
    	startTime =System.currentTimeMillis();
        
    		String str = "";
    		int data = 0;
    		try {
    			if (args == null)
    				return;
    			read = new FileReader(args); //이거는 텍스트 파일만 읽어올수 있는 것
    			//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jfcd.getSelectedFile().toString() ),"euc-kr"));
    //이거는 그림, 오디오 , 비디오텍스트등을 파일을 읽어 오는 것.
    			while (true) {
    				try {
    					data = read.read();
    					if (data == -1)
    						break;
    					else {
    						char data1 = (char) data;
    						str = str + data1;
    					}
    					if (str.length() == 3000)
    						break;
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
    			}
    		} catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    		} 
    	
            if (handlingDecision(str, args)); //continue;
            endTime = System.currentTimeMillis()-startTime;
    }

    public static boolean handlingDecision(String str, String array2) {
            if (handleNewText(str,array2)) return true;
            else
            return false;
    }

    public static boolean handleNewText(String str, String array2) {
    	
     
          text = str;// txt파일에서 읽은 str을 일단 text에 복사한다.
   
            nodes.clear();// 처음부터 다시 선택해야 할때 노드에 저장되어있는 값을 초기화 시키고 다시 선택한 값들을 집어 넣는다.
            codes.clear();
            encoded = "";
            decoded = "";
      
                
           
            calculateCharIntervals(nodes, true,array2); //빈도수
            
            buildTree(nodes); //트리에 집어넣기
            generateCodes(nodes.peek(), ""); //선두를 가져온다.. //0과1을 집어넣는다.
           
            encodeText();
            return false;
    }

    public static String decodeText(String enco) { //인코딩 값의 수정한 것을 가져오기 위해서  string enco로 가지고 온다.
        decoded = "";
        HuffmanNode node = nodes.peek();
        
        for (int i = 0; i < enco.length(); ) {
            HuffmanNode tmpNode = node;
            while (tmpNode.left != null && tmpNode.right != null && i < enco.length()) {
                if (enco.charAt(i) == '1')
                    tmpNode = tmpNode.right;
                else tmpNode = tmpNode.left;
                i++;
            }
            if (tmpNode != null)
                if (tmpNode.character.length() == 1)
                    decoded += tmpNode.character;
                else
                	JOptionPane.showMessageDialog(null, "Input not Valid"+"\n"+"인코딩 값이 모자랍니다.");


        }
        return decoded;
    }

    public static String encodeText() {
        encoded = "";
        for (int i = 0; i < text.length(); i++)
            encoded += codes.get(text.charAt(i));
        return encoded;
        
    }

    public static void buildTree(PriorityQueue<HuffmanNode> vector) {
        while (vector.size() > 1)
            vector.add(new HuffmanNode(vector.poll(), vector.poll())); //Node 클래스에 넣는다.
    }  
    		
    public static TreeMap<Character, String> printCodes() { //번호 수여
        return codes; 
    }

    public static void calculateCharIntervals(PriorityQueue<HuffmanNode> vector, boolean printIntervals, String array2) { //빈도수
        oFile = new File(array2);
    	int L =(int) (oFile.length()*100); 	
        int ASCII[] = new int[L];
        
       vector.clear();
        for (int i = 0; i < text.length(); i++)
        {  ASCII[text.charAt(i)]++;
        }
        
        
        for (int i = 0; i < ASCII.length; i++)
            if (ASCII[i] > 0) {
                vector.add(new HuffmanNode(ASCII[i] / (text.length() * 1.0), ((char) i) + ""));
            }
    }
   
    public static void generateCodes(HuffmanNode node, String s) { // 0과 1
        if (node != null) {
            if (node.right != null)
                generateCodes(node.right, s + "1");

            if (node.left != null)
                generateCodes(node.left, s + "0");

            if (node.left == null && node.right == null) // 트리에 집어 넣기
                codes.put(node.character.charAt(0), s); //charAt는 문자를 읽는다 (가로)안에 해당하는 것 0이면 0번째
        }
    }
    
    
    public static long time() {
    	return endTime;
    }
}

