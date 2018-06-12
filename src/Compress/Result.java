package Compress;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;

public class Result extends JFrame {

	private JPanel contentPane;
static long eventMask;
static double runlength;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result(eventMask, eventMask, eventMask, eventMask,runlength,eventMask);
					frame.setVisible(true);
			/*		JOptionPane.OK_CANCEL_OPTION, 
		               JOptionPane.PLAIN_MESSAGE);
			*/	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Result(long number, double endnumber, double number2,long time,double runlength,long runlengthSize) {
		
		Chart chart= new Chart(number2,runlength);
		Chart.comperrsize chartsize = chart.new comperrsize(number, endnumber, runlengthSize);
		Chart.compressTime chartTime = chart.new compressTime(time, Runlength.getTime());
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 767, 392);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel(); //수치비교
		tabbedPane.addTab("수치 비교", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "huffman", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(12, 23, 224, 282);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("원본크기: "+number+"bytes");
		lblNewLabel.setBounds(12, 39, 200, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("압축크기: "+endnumber+"bytes");
		lblNewLabel_1.setBounds(12, 87, 200, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("압축률: "+number2+"%");
		lblNewLabel_2.setBounds(12, 140, 200, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("압축시간: "+time+"ms");
		lblNewLabel_3.setBounds(12, 197, 200, 15);
		panel_2.add(lblNewLabel_3);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "run-length", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(269, 23, 225, 282);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel size = new JLabel("원본크기: "+number+"bytes");
		size.setBounds(12, 41, 201, 15);
		panel_3.add(size);
		
		JLabel compressSize = new JLabel("압축크기: "+runlengthSize+"bytes");
		compressSize.setBounds(12, 91, 201, 15);
		panel_3.add(compressSize);
		
		JLabel compressrate = new JLabel("압축률: "+runlength+"%");
		compressrate.setBounds(12, 146, 201, 15);
		panel_3.add(compressrate);
		
		JLabel compressTime = new JLabel("압축시간: "+Runlength.getTime()+"ms");
		compressTime.setBounds(12, 203, 201, 15);
		panel_3.add(compressTime);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LZW", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(522, 23, 225, 282);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel size2 = new JLabel("원본크기: "+number+"bytes");
		size2.setBounds(12, 38, 201, 15);
		panel_5.add(size2);
		
		JLabel compressSize2 = new JLabel("압축크기: "+LZW.lzwsize()+"bytes");
		compressSize2.setBounds(12, 89, 201, 15);
		panel_5.add(compressSize2);
		
		JLabel compressrate2 = new JLabel("압축률: "+LZW.lzwcompressrate()+"%");
		compressrate2.setBounds(12, 142, 201, 15);
		panel_5.add(compressrate2);
		
		JLabel compressTime2 = new JLabel("압축시간: "+LZW.lzwTime()+"ms");
		compressTime2.setBounds(12, 200, 201, 15);
		panel_5.add(compressTime2);
		
		
		
		JPanel panel_1 = new JPanel(); //그래프비교
		tabbedPane.addTab("그래프 비교", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 240, 363);
		panel_4.add(chart.getChart());
		panel_1.add(panel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(263, 0, 235, 363);
		panel_6.add(chartsize.getChartsize());
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(527, 0, 235, 363);
		panel_7.add(chartTime.getChartTime());
		panel_1.add(panel_7);
		
		
		
	}
}
