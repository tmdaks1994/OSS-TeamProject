package Compress;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.jtattoo.plaf.JTattooUtilities;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("unused")
public class Main extends JFrame {

	private JPanel contentPane;
	public static String Name = "";
	public static String named;
	public String str;
	public static String nul=null;
	public String rec;
	 static int[] array;
	 static int[] arrays;
	 static String[] integerStrings;
	 static String[] arraylzw;
	 static String lzwreulst;
	

	JFileChooser jfcd;
	JScrollPane jsp;
	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt 파일", "txt");
	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
	
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
		
		setStr(nul);//파일 선택창을 다시 불러왔을때 파일 경로값을 초기화 시켜서 압축하기 버튼을 다시 눌렀을때 경고 메세지 가 뜨게 함
		//name nameing = new name();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("압축 알고리즘 비교 프로그램");
		
		JButton btnNewButton = new JButton("압축 하기");
		btnNewButton.setBounds(390, 354, 97, 23);
		contentPane.add(btnNewButton);
		
	/*	JButton btnNewButton_1 = new JButton("압축 해제");
		btnNewButton_1.setBounds(391, 356, 97, 23);
		contentPane.add(btnNewButton_1);*/
		
		
		JLabel label = new JLabel("\uD5C8\uD504\uB9CC \uC555\uCD95"); //허프만 압축
		label.setBounds(167, 44, 80, 15);
		contentPane.add(label);
		
		
		JLabel lblNewLabel = new JLabel("\uBE44\uAD50\uB300\uC0C1 \uC555\uCD95\uC54C\uACE0\uB9AC\uC998"); //비교대상 압축알고리즘
		lblNewLabel.setBounds(607, 44, 168, 15);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(157, 10, 535, 24);
		textArea_2.setEditable(false);
		contentPane.add(textArea_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 69, 537, 275);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton_2 = new JButton("\uD30C\uC77C \uC120\uD0DD"); //파일 선택
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				
				 jfcd = new JFileChooser(
						"C://");
				 jfcd.addChoosableFileFilter(filter);
			    jfcd.showDialog(null, "확인");
			   //  jfcd.showDialog(null, "확인");
				//FileReader read = null;
				String str = "";
				int data = 0;
				try {
					if (jfcd.getSelectedFile() == null)
						return;
					//read = new FileReader(jfcd.getSelectedFile().toString()); 이거는 텍스트 파일만 읽어올수 있는 것
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jfcd.getSelectedFile().toString() ),"UTF-8"));
// 이거는 그림, 오디오 , 비디오텍스트등을 파일을 읽어 오는 것.
					while (true) {
						try {
							data = reader.read();
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
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				File selectedFile = jfcd.getSelectedFile(); // 경로 저장
				
				//textArea.setText(time.format(new Date(selectedFile.lastModified()))); // 시간 보이게 하기
				//System.out.println(time.format(new Date(selectedFile.lastModified())));
				
				textArea.setText(str); //파일 내용 보여주기
				
				
				
				//zipfile.setNamed(selectedFile);
				textArea_2.setText(selectedFile.getPath()); //경로 보여주기 
				
			/*	Name = jfcd.getSelectedFile().getName();
			setNamed(jfcd.getSelectedFile().getName());*///파일을 선택하지 않을시 압축이 되지않음
				//System.out.println(Name); 파일명
				//System.out.println(getName()); //결과 frame0
				//System.out.println(getNamed()); 파일명
			
			setStr(selectedFile.toString());
		//	System.out.println(getRe());
			//window.filestr(selectedFile.toString());
			}
		});
		
		
		btnNewButton_2.setBounds(36, 10, 97, 23); 
		contentPane.add(btnNewButton_2);
		
btnNewButton.addActionListener(new ActionListener() { //압축하기 버튼 실행
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			if(getStr()!=null) {
				File oFile = new File(getStr());
		    	long L =oFile.length();
				
				//long startTime =System.currentTimeMillis();
				//System.out.println("true");
				//hubTest hub = new hubTest(getRe());
				try {
				//	hubTest.codes.clear();
					Huffman.main(getStr());
					//length.Start(getStr());
					Runlength.main(getStr());
					//System.out.println("실행됨");
					LZW.main(getStr());
					//System.out.println(str);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				array = LZW.comresult().stream().mapToInt(i->i).toArray();
			
						
						 arraylzw = new String[array.length];
						 for(int i=0; i<arraylzw.length; i++) {
						 	arraylzw[i]=String.valueOf(array[i]);
						
						 }
						 
				
				         lzwreulst = converStringArrayToString(arraylzw," ");
				//long end = System.currentTimeMillis();
			
				Fileencoding window = new Fileencoding(Huffman.encodeText(),Huffman.printCodes(), Huffman.time(),L,Runlength.getenrunlength(),lzwreulst,LZW.resultcom());
				
				//System.out.println("여기서 실행");
				window.setVisible(true);
				window.setResizable(false);
				dispose();
		
				
				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "파일을 선택해 주세요!!!!!!");
				return;
				
			}
				
				
			}
			
			
		});
		
		/*JButton btnNewButton_3 = new JButton("\uC800\uC7A5"); //저장
		btnNewButton_3.setBounds(520, 356, 97, 23);
		contentPane.add(btnNewButton_3);
		
		
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String resultStr = null;
				resultStr = JOptionPane.showInputDialog(null,
						"저장할 파일의 이름을 지정하세요.\r\n(확장자포함)", "저장",
						JOptionPane.INFORMATION_MESSAGE);
				 jfcd = new JFileChooser(
							"C://Users//현우//Desktop");
				 jfcd.setDialogTitle("Save a File");
				 jfcd.setFileFilter(new FileNameExtensionFilter(".txt"," Text file"));
				int res= jfcd.showSaveDialog(null);
				// String resulStr = jfcd.getFileFilter().getDescription();
		
				File fi = jfcd.getSelectedFile();
				if(res == jfcd.APPROVE_OPTION) {
			String rest = textArea.getText();
			try {
				
					char data = 0;
					String resulStr = fi.getPath();
					if (resulStr == null)
						return;
					@SuppressWarnings("resource")
					DataOutputStream fw = new DataOutputStream(
							new FileOutputStream(resulStr)); // 바이트 스트림은 바이트 단위로 입출력을 함
					for (int i = 0; i < rest.length(); i++) {
						data = rest.charAt(i);
						fw.write(data);
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		*/
		
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu =new JMenu("파일");
		JMenuItem menultem= new JMenuItem("열기");
		menultem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfcd = new JFileChooser(
						"C://Users//현우//Desktop");
				 jfcd.addChoosableFileFilter(filter);
				 jfcd.showDialog(null, "확인");
				FileReader read = null;
				String str = "";
				int data = 0;
				try {
					if (jfcd.getSelectedFile() == null)
						return;
					read = new FileReader(jfcd.getSelectedFile().toString());
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

				textArea.setText(str); //파일 내용 보여주기
				
				File selectedFile = jfcd.getSelectedFile();
				//zipfile.setNamed(selectedFile);
				textArea_2.setText(selectedFile.getPath()); //경로 보여주기 
				
				named = selectedFile.getPath();
				Name = jfcd.getSelectedFile().getName();
				
				
			}
		});
		JMenuItem menultem1= new JMenuItem("저장");
		menubar.add(menu);
		menu.add(menultem);
		menu.add(menultem1);
		setJMenuBar(menubar);
	
	}

	public String getNamed() {
		return named;
	}

	public  void setNamed(String selectedFile) {
		Main.named = selectedFile;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	private static String converStringArrayToString(String[] strArr,String delimiter) {
		StringBuilder sb = new StringBuilder();
		for(String str: strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0,sb.length()-1);
	}
	
}
