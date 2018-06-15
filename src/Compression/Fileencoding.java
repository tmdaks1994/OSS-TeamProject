package Test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Fileencoding extends JFrame {

	private JPanel contentPane;
		 static String str;
	 static String title;
	 static long eventMask;
	 static long L;
	 static String runlength;
	 static List<Integer> lzwresult;
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
		setBounds(100, 100, 1028, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("파일 인코딩");
		
		Panel panel = new Panel();
		//panel.setBackground(Color.blue);
		panel.setBounds(0, 0, 1012, 701);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 26, 445, 418);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		Font f=new Font("돋움",Font.PLAIN,18);
		textArea.setFont(f);
		treeMap2.forEach((k,v) -> textArea.append("'" + k + "' : " + v+"\n")); //허프만 번호할당 찍기
		
		
		
		JButton button = new JButton("\uBE44\uAD50\uD558\uAE30"); // 비교하기
		button.setBounds(594, 647, 97, 23);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				Result tab= new Result(num,size,mm,time,Runlength.runlengthcompressionrate(),Runlength.getenrunlengthSIZE());
				tab.setVisible(true);
			        
			}
		});
		
		JButton btnNewButton = new JButton("\uD30C\uC77C \uB2E4\uC2DC \uC120\uD0DD"); //파일 다시 선택
		btnNewButton.setBounds(28, 647, 120, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC555\uCD95\uD574\uC81C"); // 압축해제
		btnNewButton_1.setBounds(399, 647, 97, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(77, 465, 445, 135);
		panel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		Font f1=new Font("돋움",Font.PLAIN,18);
		textArea_1.setFont(f1);
		textArea_1.setText(str2); //허프만 인코딩값 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(582, -2, 390, 602);
		panel.add(tabbedPane);
		
		JPanel runlengthpanel = new JPanel();
		tabbedPane.addTab("Run-length", null, runlengthpanel, null);
		runlengthpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 385, 419);
		runlengthpanel.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea(); //run-length
		scrollPane_2.setViewportView(textArea_2); 
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 442, 385, 131);
		runlengthpanel.add(scrollPane_3);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		textArea_3.setWrapStyleWord(true);
		textArea_3.setLineWrap(true);
		Font f2=new Font("돋움",Font.PLAIN,18);
		textArea_3.setFont(f2);
		textArea_3.setText(runlength); //run-length의 인코딩 값
		
		JPanel LZWpanel = new JPanel();
		tabbedPane.addTab("LZW", null, LZWpanel, null);
		LZWpanel.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 385, 416);
		LZWpanel.add(scrollPane_4);
		
		JTextArea textArea_4 = new JTextArea();
		scrollPane_4.setViewportView(textArea_4);
		Font f3=new Font("돋움",Font.PLAIN,18);
		textArea_4.setFont(f3);
		map.forEach((k,v) -> textArea_4.append("'" + k + "' : " + v+"\n")); // lzw 번호 수여 값
		
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 438, 385, 135);
		LZWpanel.add(scrollPane_5);
		
		JTextArea textArea_5 = new JTextArea();
		scrollPane_5.setViewportView(textArea_5);
		textArea_5.setLineWrap(true);
		textArea_5.setWrapStyleWord(true);
		Font f5=new Font("돋움",Font.PLAIN,18);
		textArea_5.setFont(f5);
		textArea_5.setText(lzwreulst); //lzw 인코딩 값
		
		 textArea_5.getText();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 6, 120, 23);
		panel.add(panel_1);
		
				JLabel lblHuffman = new JLabel("Huffman");
				panel_1.add(lblHuffman);
		
		
		
		btnNewButton.addActionListener(new ActionListener() { // 파일 다시 선택하기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Test.Main zip = new Test.Main();
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
}
