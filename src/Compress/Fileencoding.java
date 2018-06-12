package Compress;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

public class Fileencoding extends JFrame {

	private JPanel contentPane;
		 static String str;
	 static String title;
	 private static int result;
	 static long eventMask;
	 static long L;
	 //static String runlength;
	 static String runlength;
	 static List<Integer> lzwresult;
	// static String num1;
	// static int[] array;
	 static int[] arrays;
	 static String[] integerStrings;
	 static String[] arraylzw;
	 static String lzwreulst;
	/**
	 * Launch the application.
	 */static TreeMap<Character, String> treeMap=new TreeMap<>();
	 static Map<String, Integer> treeMap1=new HashMap<>();
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Fileencoding frame = new Fileencoding(str, treeMap, eventMask,L,runlength,lzwreulst,treeMap1);
					frame.setVisible(true);
					frame.setResizable(false);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param title2 
	 * @param treeMap2 
	 * @param str2 
	 * @param string 
	 */
	public Fileencoding(String str2, TreeMap<Character, String> treeMap2,long time,long num,String runlength,String lzwreulst,Map<String, Integer> map) {
		  double endnum= (double)str2.length()/8; //압축크기
	    //  String endnumber=String.format("%.2f", endnum);
	      double size= Math.round(endnum*100d)/100d;
	      double zipnumber=100-(endnum/num)*100; // 압축률
	      double mm = Math.round(zipnumber*100d)/100d;
	    //  String number = String.format("%.2f", zipnumber);
	      
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("파일 인코딩");
		
		Panel panel = new Panel();
		//panel.setBackground(Color.blue);
		panel.setBounds(0, 0, 764, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 24, 360, 300);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		treeMap2.forEach((k,v) -> textArea.append("'" + k + "' : " + v+"\n"));
		
		
		
		JButton button = new JButton("\uBE44\uAD50\uD558\uAE30"); // 비교하기
		button.setBounds(422, 428, 97, 23);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				Result tab= new Result(num,size,mm,time,Runlength.runlengthcompressionrate(),Runlength.getenrunlengthSIZE());
				tab.setVisible(true);
			        
			}
		});
		
		JButton btnNewButton = new JButton("\uD30C\uC77C \uB2E4\uC2DC \uC120\uD0DD"); //파일 다시 선택
		btnNewButton.setBounds(12, 428, 120, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC555\uCD95\uD574\uC81C"); // 압축해제
		btnNewButton_1.setBounds(296, 428, 97, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 351, 360, 55);
		panel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText(str2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(434, 0, 318, 418);
		panel.add(tabbedPane);
		
		JPanel runlengthpanel = new JPanel();
		tabbedPane.addTab("Run-length", null, runlengthpanel, null);
		runlengthpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 313, 295);
		runlengthpanel.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 330, 313, 49);
		runlengthpanel.add(scrollPane_3);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		textArea_3.setWrapStyleWord(true);
		textArea_3.setLineWrap(true);
		textArea_3.setText(runlength);
		
		JPanel LZWpanel = new JPanel();
		tabbedPane.addTab("LZW", null, LZWpanel, null);
		LZWpanel.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 313, 296);
		LZWpanel.add(scrollPane_4);
		
		JTextArea textArea_4 = new JTextArea();
		scrollPane_4.setViewportView(textArea_4);
		map.forEach((k,v) -> textArea_4.append("'" + k + "' : " + v+"\n"));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 329, 311, 50);
		LZWpanel.add(scrollPane_5);
		
		JTextArea textArea_5 = new JTextArea();
		scrollPane_5.setViewportView(textArea_5);
		textArea_5.setLineWrap(true);
		textArea_5.setWrapStyleWord(true);
		textArea_5.setText(lzwreulst);
		

		//textArea_5.setText(list.toString());
		 textArea_5.getText();
		//System.out.println(textArea_5.getText());
		 //System.out.println(num1);

/*String[] arrays = list.toArray(new String[list.size()]);
for(int i=0; i<arrays.length; i++) {
System.out.println(arrays[i]);
}*/

//textArea_5.setText(list.toString());




		JLabel lblHuffman = new JLabel("Huffman");
		lblHuffman.setBounds(24, 4, 57, 15);
		panel.add(lblHuffman);
		
		
		
		btnNewButton.addActionListener(new ActionListener() { // 파일 다시 선택하기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Compress.Main zip = new Compress.Main();
							zip.setVisible(true);
							zip.setResizable(false);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Filedecoding fram = new Filedecoding(textArea_1.getText() ,textArea_5.getText() , textArea_3.getText());
				fram.setVisible(true);
				
				
			}
		});
		
		
		
		
	}
	public static List<Integer> lzwlistin(int[] input) {
		
		List<Integer> lzwlist=new ArrayList<Integer>();
		for(int i: input) {
			lzwlist.add(i);
		}
		return lzwlist;
	}
	
}
