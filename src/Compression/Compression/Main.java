package Compression;


import java.awt.EventQueue;
import java.awt.Font;
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
	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt ����", "txt");
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
		
		setStr(nul);//���� ����â�� �ٽ� �ҷ������� ���� ��ΰ��� �ʱ�ȭ ���Ѽ� �����ϱ� ��ư�� �ٽ� �������� ��� �޼��� �� �߰� ��
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1028, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("���� �˰��� �� ���α׷�");
		
		JButton btnNewButton = new JButton("���� �ϱ�");
		btnNewButton.setBounds(486, 592, 117, 37);
		contentPane.add(btnNewButton);
			
		JLabel label = new JLabel("���� ���� ����"); //������ ����
		label.setBounds(499, 44, 80, 15);
		contentPane.add(label);
		
		JTextArea textArea_2 = new JTextArea(); //���� ���
		textArea_2.setBounds(157, 10, 755, 24);
		textArea_2.setEditable(false);
		contentPane.add(textArea_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 69, 755, 500);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea(); // ���� �ؽ�Ʈ ������ �����ִ� ��
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton_2 = new JButton("\uD30C\uC77C \uC120\uD0DD"); //���� ����
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				
				 jfcd = new JFileChooser(
						"C://Users//Desktop");
				 jfcd.addChoosableFileFilter(filter);
			    jfcd.showDialog(null, "Ȯ��");
				//FileReader read = null;
				String str = "";
				int data = 0;
				try {
					if (jfcd.getSelectedFile() == null)
						return;
					//read = new FileReader(jfcd.getSelectedFile().toString()); �̰Ŵ� �ؽ�Ʈ ���ϸ� �о�ü� �ִ� ��
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jfcd.getSelectedFile().toString() ),"UTF-8"));
// �̰Ŵ� �׸�, ����� , �����ؽ�Ʈ���� ������ �о� ���� ��.
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
				
				File selectedFile = jfcd.getSelectedFile(); // ��� ����
				
				Font f1=new Font("����",Font.PLAIN,20);
				textArea.setFont(f1);
				textArea.setText(str); //���� ���� �����ֱ�		
				textArea_2.setText(selectedFile.getPath()); //��� �����ֱ� 
		
			
			setStr(selectedFile.toString());
			}
		});
		
		
		btnNewButton_2.setBounds(36, 10, 97, 23); 
		contentPane.add(btnNewButton_2);
		
btnNewButton.addActionListener(new ActionListener() { //�����ϱ� ��ư ����
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			if(getStr()!=null) {
				File oFile = new File(getStr());
		    	long L =oFile.length();
		    	
				try {
					Huffman.main(getStr());
				
					Runlength.main(getStr());
					
					LZW.main(getStr());
			
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//lzw����˰����� ���ڵ� ������ �Ϸ��� �ϴ� ��ȭ����
				array = LZW.comresult().stream().mapToInt(i->i).toArray();
			
						 arraylzw = new String[array.length];
						 for(int i=0; i<arraylzw.length; i++) {
						 	arraylzw[i]=String.valueOf(array[i]);		
						 }
						 
				
				         lzwreulst = converStringArrayToString(arraylzw," ");
			
				Fileencoding window = new Fileencoding(Huffman.encodeText(),Huffman.printCodes(), Huffman.time(),L,Runlength.getenrunlength(),lzwreulst,LZW.resultcom());
				
				window.setVisible(true);
				window.setResizable(false);
				dispose();
				
			}else {
				JOptionPane.showMessageDialog(null, "������ ������ �ּ���!!!!!!");
				return;				
			}
				
			}
			
		});		
		/*JButton btnNewButton_3 = new JButton("\uC800\uC7A5"); //����
		btnNewButton_3.setBounds(520, 356, 97, 23);
		contentPane.add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String resultStr = null;
				resultStr = JOptionPane.showInputDialog(null,
						"������ ������ �̸��� �����ϼ���.\r\n(Ȯ��������)", "����",
						JOptionPane.INFORMATION_MESSAGE);
				 jfcd = new JFileChooser(
							"C://Users//����//Desktop");
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
							new FileOutputStream(resulStr)); // ����Ʈ ��Ʈ���� ����Ʈ ������ ������� ��
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
		JMenu menu =new JMenu("����");
		JMenuItem menultem= new JMenuItem("����");
		menultem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 jfcd = new JFileChooser(
						"C://Users//Desktop");
				 jfcd.addChoosableFileFilter(filter);
			    jfcd.showDialog(null, "Ȯ��");
				//FileReader read = null;
				String str = "";
				int data = 0;
				try {
					if (jfcd.getSelectedFile() == null)
						return;
					//read = new FileReader(jfcd.getSelectedFile().toString()); �̰Ŵ� �ؽ�Ʈ ���ϸ� �о�ü� �ִ� ��
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jfcd.getSelectedFile().toString() ),"UTF-8"));
//�̰Ŵ� �׸�, ����� , �����ؽ�Ʈ���� ������ �о� ���� ��.
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
				} catch (UnsupportedEncodingException k) {
					// TODO Auto-generated catch block
					k.printStackTrace();
				}
				
				File selectedFile = jfcd.getSelectedFile(); // ��� ����
				Font f1=new Font("����",Font.PLAIN,20);
				textArea.setFont(f1);
				textArea.setText(str); //���� ���� �����ֱ�		
				textArea_2.setText(selectedFile.getPath()); //��� �����ֱ� 
		
			
			setStr(selectedFile.toString());
						
			}
		});
		JMenuItem menultem1= new JMenuItem("����");
		menultem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
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
