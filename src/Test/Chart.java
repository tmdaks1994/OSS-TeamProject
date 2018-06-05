package Test;

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
	
	
	public Chart(double huffman,long time, double endnumber){
	DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		
	dataset1.addValue(huffman, "허프만", "압축률");
	dataset1.addValue(0, "런랭스", "압축률");
	dataset1.addValue(sizeget(endnumber), "허프만", "압축크기");
	dataset1.addValue(0, "런랭스", "압축크기");
	
	dataset1.addValue(time, "허프만", "압축시간");
	dataset1.addValue(0, "런랭스", "압축시간");
	
	final CategoryItemRenderer renderer = new BarRenderer();
	// renderer.setLabelGenerator(generator);
	renderer.setItemLabelsVisible(false);

	final CategoryPlot plot = new CategoryPlot();
	plot.setDataset(dataset1);
	plot.setRenderer(renderer);

	plot.setDomainAxis(new CategoryAxis(""));
	plot.setRangeAxis(new NumberAxis("압축률"));
	plot.getRangeAxis().setRange(0, 100);
	plot.setOrientation(PlotOrientation.VERTICAL);
	plot.setRangeGridlinesVisible(true);
	plot.setDomainGridlinesVisible(true);

	plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

	plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
	chart = new JFreeChart(plot);
	chart.setTitle("그래프 비교");

	chartPanel = new ChartPanel(chart);
	chartPanel.setPreferredSize(new java.awt.Dimension(450, 330));
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
