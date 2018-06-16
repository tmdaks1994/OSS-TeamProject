package Compression;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class Filedecoding extends JFrame {

	private JPanel contentPane;
static String title;
static String lzw;
static String runlength;
static List<Integer> result;
static int[] arrays;
static String[] integerStrings;
static String[] arraylzw;
static String lzwreulst;
static List<Integer> li=new ArrayList<Integer>();	
static List<Integer> lzwlist;
static List<Integer> lzwlistin=new ArrayList<Integer>();
/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filedecoding frame = new Filedecoding( title, lzw, runlength);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param title 
	 */
	public Filedecoding(String str, String lzw, String runlength) {
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
		
	//	li.clear();
	//	lzwlist.clear();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1028, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("파일 디코딩(파일 압축해제)");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1012, 657);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 45, 423, 528);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		Font f= new Font("돋음",Font.PLAIN,18);
		textArea.setFont(f);
		textArea.setText(Huffman.decodeText(str)); //Huffman 디코딩한 값
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(531, 22, 423, 548);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Run-length", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 418, 519);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		Font f1= new Font("돋음",Font.PLAIN,18);
		textArea_1.setFont(f1);
		textArea_1.setText(Runlength.lengthdecoding(runlength)); //run-length 디코딩된 값
		
		JPanel LZWpanel = new JPanel();
		tabbedPane.addTab("LZW", null, LZWpanel, null);
		LZWpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 418, 519);
		LZWpanel.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		textArea.setEditable(false);
		Font f2= new Font("돋음",Font.PLAIN,18);
		textArea_2.setFont(f2);
		
		li.clear();
		lzwlistin.clear();
		// lzw를 디코딩하기 위해서 string값을 다시 list<integer>값으로 변환시켜서 보내고 다시 불러온다.
		 integerStrings= lzw.split(" ");
		  arrays = new int[integerStrings.length];
		 
	for(int number=0; number<arrays.length; number++) {
		arrays[number]= Integer.parseInt(integerStrings[number]);
	}
	
	
	for(int i: arrays) {
		lzwlistin.add(i);
	}
	
	 li= lzwlistin;
	
		textArea_2.setText(LZW.decompress(li));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(81, 10, 111, 38);
		panel.add(panel_2);
		
		JLabel lblHuffman = new JLabel("Huffman");
		panel_2.add(lblHuffman);
		//textArea_2.setText(lzwTest.decompress(lzwreult));
		
		
	}
}
