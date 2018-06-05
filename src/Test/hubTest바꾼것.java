package Test;

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

public class hubTest바꾼것 {
    static final boolean readFromFile = false;
    static final boolean newTextBasedOnOldOne = false;
static JFileChooser jfcd;
static FileNameExtensionFilter filter = new FileNameExtensionFilter("txt 파일", "txt");
static FileReader read;
static File oFile;

    static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> (o1.value < o2.value) ? -1 : 1);
    static TreeMap<Character, String> codes = new TreeMap<>(); //character 문자 셋
    static String text = "";
    static String array;
    static String encoded = "";
    static String decoded = "";
    static long startTime;
    static long endTime;
    
    public static void main(String args) throws FileNotFoundException {
        int decision = 1;
        
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
    		} /*catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}*/
    		//File selectedFile = jfcd.getSelectedFile(); // 경로 저장
    	
    	
            if (handlingDecision(str, decision, args)); //continue;
            //decision = consoleMenu(scanner);
      
    }

   /* private static int consoleMenu(Scanner scanner) {
        int decision;
        System.out.println("\n---- Menu ----\n" +
                "-- [-1] to exit \n" +
                "-- [1] to enter new text\n" +
                "-- [2] to encode a text\n" +
                "-- [3] to decode a text");
        decision = Integer.parseInt(scanner.nextLine());
        if (readFromFile)
            System.out.println("Decision: " + decision + "\n---- End of Menu ----\n");
        return decision;
    }*/

    public static boolean handlingDecision(String str, int decision, String array2) {
        if (decision == 1) {
            if (handleNewText(str,array2)) return true;
        } /*else if (decision == 2) {
            if (handleEncodingNewText(str)) return true;
        } else if (decision == 3) {
            handleDecodingNewText(str);
        }*/
        return false;
    }

    /*public static void handleDecodingNewText(String str) {
        System.out.println("Enter the text to decode:");
        encoded = str;
        System.out.println("Text to Decode: " + encoded);
        decodeText();
    }*/

 /*   public static boolean handleEncodingNewText(String str) {
        System.out.println("Enter the text to encode:");
        text = str;
        System.out.println("Text to Encode: " + text);

        if (!IsSameCharacterSet()) {
            System.out.println("Not Valid input");
            text = "";
            return true;
        }
        encodeText();
        return false;
    }*/

    public static boolean handleNewText(String str, String array2) {
    	
    /*	oFile = new File(array2);
    	long L =oFile.length(); //처음 파일 크기
    	*/
     
          text = str;// txt파일에서 읽은 str을 일단 text에 복사한다.
   
   /*     if (newTextBasedOnOldOne && (oldTextLength != 0 && !IsSameCharacterSet())) {
            System.out.println("Not Valid input");
            text = "";
            return true;
        }*/
            nodes.clear();// 처음부터 다시 선택해야 할때 노드에 저장되어있는 값을 초기화 시키고 다시 선택한 값들을 집어 넣는다.
            codes.clear();
            encoded = "";
            decoded = "";
      
                
            calculateCharIntervals(nodes, true,array2); //빈도수
          //  startTime =System.currentTimeMillis();
            
            buildTree(nodes); //트리에 집어넣기
            generateCodes(nodes.peek(), ""); //선두를 가져온다.. //0과1을 집어넣는다.
          //  endTime= System.currentTimeMillis()-startTime; //압축 시간??
           
            encodeText();
        
            // decodeText();
          //  System.out.println(L+ " bytes");
        //    System.out.println(L*8+"bit");
            return false;



    }

 /*   public static boolean IsSameCharacterSet() {
        boolean flag = true;
        for (int i = 0; i < text.length(); i++)
            if (ASCII[text.charAt(i)] == 0) {
                flag = false;
                break;
            }
        return flag;
    }*/

    public static String decodeText(String enco) {
        decoded = "";
        Node node = nodes.peek();
        
        for (int i = 0; i < enco.length(); ) {
            Node tmpNode = node;
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
       // System.out.println("Decoded Text: " + decoded);
        return decoded;
    }

    public static String encodeText() {
        encoded = "";
        for (int i = 0; i < text.length(); i++)
            encoded += codes.get(text.charAt(i));
      //  System.out.println("Encoded Text:" + encoded);
   //     System.out.println(encoded.length()+"bit");
     //   System.out.println(encoded.length()*8+"bytes");
        
        return encoded;
        
    }

    public static void buildTree(PriorityQueue<Node> vector) {
        while (vector.size() > 1)
            vector.add(new Node(vector.poll(), vector.poll())); //Node 클래스에 넣는다.
    }  
    		
    public static TreeMap<Character, String> printCodes() { //번호 수여
       // System.out.println("--- Printing Codes ---");
       
      //  codes.forEach((k, v) -> System.out.println("'" + k + "' : " + v));
       // System.out.println("----------------------------------------");
        return codes;
    }

    public static void calculateCharIntervals(PriorityQueue<Node> vector, boolean printIntervals, String array2) { //빈도수
     //   if (printIntervals) System.out.println("-- intervals --");
      
        //arr.add(text);
        oFile = new File(array2);
    	int L =(int) (oFile.length()*100); 
    	
    	
        int ASCII[] = new int[L];
       vector.clear();
        for (int i = 0; i < text.length(); i++)
        {  ASCII[text.charAt(i)]++;
        }
        
        
        for (int i = 0; i < ASCII.length; i++)
            if (ASCII[i] > 0) {
                vector.add(new Node(ASCII[i] / (text.length() * 1.0), ((char) i) + ""));
               // if (printIntervals)
                 //   System.out.println("'" + ((char) i) + "' : " +( ASCII[i] / (text.length()*1.0)) * 100);
            }
    }
    								//generateCodes(nodes.peek(), "");
    public static void generateCodes(Node node, String s) { // 0과 1
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

