package Compress;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart extends JFrame {
	private JFreeChart chart;
	
	
	private static ChartPanel chartPanel;
	
	
	double size;
	double times;
	
	
	public Chart(double huffman, double runlength){
	DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
	
	
	dataset1.addValue(huffman, "������", "�����");
	dataset1.addValue(runlength, "������", "�����");
	//dataset1.addValue(sizeget(endnumber), "������", "����ũ��");
//dataset1.addValue(sizeget(runlengthsize), "������", "����ũ��");
	
	//dataset1.addValue(time, "������", "����ð�");
	//dataset1.addValue(runlengthTime, "������", "����ð�");
	
	dataset1.addValue(LZW.lzwcompressrate(), "lzw", "�����");
	
	final CategoryItemRenderer renderer = new BarRenderer();
	// renderer.setLabelGenerator(generator);
	renderer.setItemLabelsVisible(false);

	final CategoryPlot plot = new CategoryPlot();
	plot.setDataset(dataset1);
	plot.setRenderer(renderer);
	
	plot.setDomainAxis(new CategoryAxis(""));
	plot.setRangeAxis(new NumberAxis("�����"));
	plot.getRangeAxis().setRange(0, 100);
	plot.setOrientation(PlotOrientation.VERTICAL);
	plot.setRangeGridlinesVisible(true);
	plot.setDomainGridlinesVisible(true);

	plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

	plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
	
	chart = new JFreeChart(plot);
	chart.setTitle("�����");

	chartPanel = new ChartPanel(chart);
	
	chartPanel.setPreferredSize(new java.awt.Dimension(230, 350));
	setChart(chartPanel);
	
	}
	
	public void setChart(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

	public JPanel getChart() {
		return chartPanel;
	}
	
	
	public double sizeget(double endnumber) {
		if(endnumber<=100) {
			size=endnumber;
			
		}else if(endnumber<=1000) {
			size=endnumber/10;
			
		}else if(endnumber<=10000) {
			size=endnumber/100;
		
		}else if(endnumber<=100000) {
			size=endnumber/1000;
		
		}
		
		return size;
	}
	
	
	public class comperrsize{
		private ChartPanel chartPanelsize;
		private JFreeChart chartSize;
		
		public comperrsize(long size,double endnumber,double runlengthsize) {
			
			//����ũ��
			DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
			
			dataset2.addValue(endnumber, "������", "����ũ��");
			dataset2.addValue(runlengthsize, "������", "����ũ��");
			dataset2.addValue(LZW.lzwsize(), "lzw", "����ũ��");
			
			final CategoryItemRenderer renderer2 = new BarRenderer();
			// renderer.setLabelGenerator(generator);
			renderer2.setItemLabelsVisible(false);

			
			final CategoryPlot plot2 = new CategoryPlot();
			plot2.setDataset(dataset2);
			plot2.setRenderer(renderer2);
			
			plot2.setDomainAxis(new CategoryAxis(""));
			plot2.setRangeAxis(new NumberAxis("����ũ��"));
			plot2.getRangeAxis().setRange(0, size*2);
			plot2.setOrientation(PlotOrientation.VERTICAL);
			plot2.setRangeGridlinesVisible(true);
			plot2.setDomainGridlinesVisible(true);

			plot2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
			plot2.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
			
			chartSize = new JFreeChart(plot2);
			chartSize.setTitle("����ũ��");

			chartPanelsize = new ChartPanel(chartSize);
			chartPanelsize.setPreferredSize(new java.awt.Dimension(230, 350));
			setChartsize(chartPanelsize);
		}
		
		public void setChartsize(ChartPanel chartPanelsize) {
			this.chartPanelsize = chartPanelsize;
		}

		public  JPanel getChartsize() {
			return chartPanelsize;
		}
		
	}
	
	
	public class compressTime{
		
		private ChartPanel chartPanelTime;
		private JFreeChart chartTime;
		
		public compressTime(long huffmantime,long runlengthtime) {
			
DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
			
			dataset3.addValue(huffmantime, "������", "����ð�");
			dataset3.addValue(runlengthtime, "������", "����ð�");
			dataset3.addValue(LZW.lzwTime(), "lzw", "����ð�");
			
			final CategoryItemRenderer renderer3 = new BarRenderer();
			// renderer.setLabelGenerator(generator);
			renderer3.setItemLabelsVisible(false);

			
			final CategoryPlot plot3 = new CategoryPlot();
			plot3.setDataset(dataset3);
			plot3.setRenderer(renderer3);
			
			plot3.setDomainAxis(new CategoryAxis(""));
			plot3.setRangeAxis(new NumberAxis("����ð�"));
			plot3.getRangeAxis().setRange(0, 10);
			plot3.setOrientation(PlotOrientation.VERTICAL);
			plot3.setRangeGridlinesVisible(true);
			plot3.setDomainGridlinesVisible(true);
			
			plot3.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
			plot3.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
			
			chartTime = new JFreeChart(plot3);
			chartTime.setTitle("����ð�");

			chartPanelTime = new ChartPanel(chartTime);
			chartPanelTime.setPreferredSize(new java.awt.Dimension(230, 350));
			setChartTimee(chartPanelTime);
			
			
		}
		public void setChartTimee(ChartPanel chartPanelTime) {
			this.chartPanelTime = chartPanelTime;
		}

		public  JPanel getChartTime() {
			return chartPanelTime;
		}
		
		
		public double timeget(double time) {
			
			if(time<=100) {
				times=time;
			}else if(time<=1000){
				times=time/100;
			}else if(time<=10000){
				times=time/1000;
			}
			
			
			return time;
		}
	}
	
	
}
