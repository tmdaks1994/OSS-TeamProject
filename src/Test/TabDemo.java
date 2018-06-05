package Test;

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

public class TabDemo extends JFrame {

	private JPanel contentPane;
static long eventMask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabDemo frame = new TabDemo(eventMask, eventMask, eventMask, eventMask);
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
	public TabDemo(double number, double endnumber, double number2,long time) {
		Chart chart= new Chart(number2,time, endnumber);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 511, 344);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel(); //��ġ��
		tabbedPane.addTab("��ġ ��", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "huffman", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(12, 23, 224, 282);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����ũ��: "+number+"bytes");
		lblNewLabel.setBounds(12, 39, 200, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����ũ��: "+endnumber+"bytes");
		lblNewLabel_1.setBounds(12, 87, 200, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�����: "+number2+"%");
		lblNewLabel_2.setBounds(12, 140, 200, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("����ð�: "+time+"ms");
		lblNewLabel_3.setBounds(12, 197, 200, 15);
		panel_2.add(lblNewLabel_3);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "run-length", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(269, 23, 225, 282);
		panel.add(panel_3);
		
		
		
		JPanel panel_1 = new JPanel(); //�׷�����
		tabbedPane.addTab("�׷��� ��", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 506, 315);
		panel_4.add(chart.getChart());
		panel_1.add(panel_4);
		
		
		
	}
}
