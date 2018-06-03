package compression;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class file extends JFrame {
 public static void main(String[] args) {
	JFrame window =new JFrame();
// 파일 창 객제를 나타낸다.
JFileChooser fileChooser =new JFileChooser();

//기본 path의 경로 설정(바탕화면)
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+ "//"+ "Desktop"));
 //필터링될 확장자
FileNameExtensionFilter filter = new FileNameExtensionFilter("txt 파일", "txt");
//필터릴될 확장자 추가
fileChooser.addChoosableFileFilter(filter);

fileChooser.setDialogTitle("압축파일 열기"); //타이틀 
fileChooser.setMultiSelectionEnabled(true); //파일을 여러개 선택
//FileChooser사용자가 파일을 선택하거나 디렉토리를 선택하거나 파일과 디렉토리를 모두 선택할 수 있도록 설정합니다 .
fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

//파일오픈 다리얼로그를 띄움
int result = fileChooser.showOpenDialog(window);
System.out.println(result);


if(result == JFileChooser.APPROVE_OPTION) {
	File [] filed = fileChooser.getSelectedFiles();
	//선택한 파일의 경로 반환
	//File selectedFile = fileChooser.getSelectedFile();
	
//System.out.println(selectedFile); 파일을 하나 선택할 때만 나타낸다.
	
	System.out.println("Directories found\n");   //파일과 디렉토리를 동시에 선택한것을 구분해서 보여주고있다.
Arrays.asList(filed).forEach(x -> { 
if (x.isDirectory()) { System.out.println(x.getName()); } }); 
System.out.println("\n- - - - - - - - - - -\n"); 
System.out.println("Files Found\n");
 Arrays.asList(filed).forEach(x -> { 
if (x.isFile()) { System.out.println(x.getName()); } });
}
 }

}
