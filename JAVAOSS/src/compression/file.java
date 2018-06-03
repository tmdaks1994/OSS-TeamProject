package compression;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class file extends JFrame {
 public static void main(String[] args) {
	JFrame window =new JFrame();
// ���� â ������ ��Ÿ����.
JFileChooser fileChooser =new JFileChooser();

//�⺻ path�� ��� ����(����ȭ��)
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+ "//"+ "Desktop"));
 //���͸��� Ȯ����
FileNameExtensionFilter filter = new FileNameExtensionFilter("txt ����", "txt");
//���͸��� Ȯ���� �߰�
fileChooser.addChoosableFileFilter(filter);

fileChooser.setDialogTitle("�������� ����"); //Ÿ��Ʋ 
fileChooser.setMultiSelectionEnabled(true); //������ ������ ����
//FileChooser����ڰ� ������ �����ϰų� ���丮�� �����ϰų� ���ϰ� ���丮�� ��� ������ �� �ֵ��� �����մϴ� .
fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

//���Ͽ��� �ٸ���α׸� ���
int result = fileChooser.showOpenDialog(window);
System.out.println(result);


if(result == JFileChooser.APPROVE_OPTION) {
	File [] filed = fileChooser.getSelectedFiles();
	//������ ������ ��� ��ȯ
	//File selectedFile = fileChooser.getSelectedFile();
	
//System.out.println(selectedFile); ������ �ϳ� ������ ���� ��Ÿ����.
	
	System.out.println("Directories found\n");   //���ϰ� ���丮�� ���ÿ� �����Ѱ��� �����ؼ� �����ְ��ִ�.
Arrays.asList(filed).forEach(x -> { 
if (x.isDirectory()) { System.out.println(x.getName()); } }); 
System.out.println("\n- - - - - - - - - - -\n"); 
System.out.println("Files Found\n");
 Arrays.asList(filed).forEach(x -> { 
if (x.isFile()) { System.out.println(x.getName()); } });
}
 }

}
