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

public class hubTest�ٲ۰� {
    static final boolean readFromFile = false;
    static final boolean newTextBasedOnOldOne = false;
static JFileChooser jfcd;
static FileNameExtensionFilter filter = new FileNameExtensionFilter("txt ����", "txt");
static FileReader read;
static File oFile;

    static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> (o1.value < o2.value) ? -1 : 1);
    static TreeMap<Character, String> codes = new TreeMap<>(); //character ���� ��
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
    			read = new FileReader(args); //�̰Ŵ� �ؽ�Ʈ ���ϸ� �о�ü� �ִ� ��
    			//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jfcd.getSelectedFile().toString() ),"euc-kr"));
    //�̰Ŵ� �׸�, ����� , �����ؽ�Ʈ���� ������ �о� ���� ��.
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
    		//File selectedFile = jfcd.getSelectedFile(); // ��� ����
    	
    	
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
    	long L =oFile.length(); //ó�� ���� ũ��
    	*/
     
          text = str;// txt���Ͽ��� ���� str�� �ϴ� text�� �����Ѵ�.
   
   /*     if (newTextBasedOnOldOne && (oldTextLength != 0 && !IsSameCharacterSet())) {
            System.out.println("Not Valid input");
            text = "";
            return true;
        }*/
            nodes.clear();// ó������ �ٽ� �����ؾ� �Ҷ� ��忡 ����Ǿ��ִ� ���� �ʱ�ȭ ��Ű�� �ٽ� ������ ������ ���� �ִ´�.
            codes.clear();
            encoded = "";
            decoded = "";
      
                
            calculateCharIntervals(nodes, true,array2); //�󵵼�
          //  startTime =System.currentTimeMillis();
            
            buildTree(nodes); //Ʈ���� ����ֱ�
            generateCodes(nodes.peek(), ""); //���θ� �����´�.. //0��1�� ����ִ´�.
          //  endTime= System.currentTimeMillis()-startTime; //���� �ð�??
           
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
                	JOptionPane.showMessageDialog(null, "Input not Valid"+"\n"+"���ڵ� ���� ���ڶ��ϴ�.");


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
            vector.add(new Node(vector.poll(), vector.poll())); //Node Ŭ������ �ִ´�.
    }  
    		
    public static TreeMap<Character, String> printCodes() { //��ȣ ����
       // System.out.println("--- Printing Codes ---");
       
      //  codes.forEach((k, v) -> System.out.println("'" + k + "' : " + v));
       // System.out.println("----------------------------------------");
        return codes;
    }

    public static void calculateCharIntervals(PriorityQueue<Node> vector, boolean printIntervals, String array2) { //�󵵼�
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
    public static void generateCodes(Node node, String s) { // 0�� 1
        if (node != null) {
            if (node.right != null)
                generateCodes(node.right, s + "1");

            if (node.left != null)
                generateCodes(node.left, s + "0");

            if (node.left == null && node.right == null) // Ʈ���� ���� �ֱ�
                codes.put(node.character.charAt(0), s); //charAt�� ���ڸ� �д´� (����)�ȿ� �ش��ϴ� �� 0�̸� 0��°
        }
    }
    
    
    public static long time() {
    	return endTime;
    }
}

