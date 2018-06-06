package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import 압축.zipfile;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;

public class Newwindow extends JFrame {

	private JPanel contentPane;
		 static String str;
	 static String title;
	 private static int result;
	 static long eventMask;
	 static long L;
	 static String runlength;
	/**
	 * Launch the application.
	 */static TreeMap<Character, String> treeMap=new TreeMap<>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Newwindow frame = new Newwindow(str, treeMap, eventMask,L,runlength);
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
	public Newwindow(String str2, TreeMap<Character, String> treeMap2,long time,long num,String runlength) {
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
		//textArea.setText(" "+treeMap+"\n"+str);
	//	System.out.println("여기는 아님");
		treeMap2.forEach((k,v) -> textArea.append("'" + k + "' : " + v+"\n"));
		
		
		
		JButton button = new JButton("\uBE44\uAD50\uD558\uAE30"); // 비교하기
		button.setBounds(422, 428, 97, 23);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			/*	JTextField lField = new JTextField(5); //lenght field 
			      JTextField wField = new JTextField(5); //col field
			    
			      
			      //design input line
			      JPanel choosePanel [] = new JPanel [5];
			       choosePanel [0] = new JPanel();
			       choosePanel [1] = new JPanel();
			       choosePanel [2] = new JPanel();
			       choosePanel [3] = new JPanel();
			       choosePanel [4] = new JPanel();
			       
			       
			      choosePanel[0].add(new JLabel("압축 정보") );
			      
			      choosePanel[1].add(new JLabel("원본크기: "+num+"bytes"));
			      //choosePanel[1].add(lField);
			      choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer
			      
			      choosePanel[2].add(new JLabel("압축크기:"+ endnumber+"bytes"));
			      //choosePanel[2].add(wField);
			      choosePanel[2].add(Box.createHorizontalStrut(15));
			      
			      choosePanel[3].add(new JLabel("압축률: "+ number+"%"));
			     // choosePanel[3].add(wField);
			      choosePanel[3].add(Box.createHorizontalStrut(15));

			      choosePanel[4].add(new JLabel("압축시간: "+time+"ms"));
			     // choosePanel[4].add(wField);
			      choosePanel[4].add(Box.createHorizontalStrut(15));

			      
			      result = JOptionPane.showConfirmDialog(null, choosePanel, 
			               null,JOptionPane.OK_CANCEL_OPTION, 
			               JOptionPane.PLAIN_MESSAGE);*/
				
				TabDemo tab= new TabDemo(num,size,mm,time);
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
		scrollPane_1.setBounds(24, 351, 360, 43);
		panel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText(str2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(437, 25, 315, 300);
		panel.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(434, 352, 318, 41);
		panel.add(scrollPane_3);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		textArea_3.setWrapStyleWord(true);
		textArea_3.setLineWrap(true);
		textArea_3.setText(runlength);
		
		
		btnNewButton.addActionListener(new ActionListener() { // 파일 다시 선택하기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Test.zipfile zip = new Test.zipfile();
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
				newframe fram = new newframe(textArea_1.getText());
				fram.setVisible(true);
				
				
			}
		});
		
		
		
		
	}
}
