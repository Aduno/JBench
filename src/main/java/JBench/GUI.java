package JBench;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GUI extends ApplicationFrame {
    long[][] times;
    private GUI(String title, String chartTitle, long[][] times){
        super(title);
        this.times= times;
        JFreeChart barGraph = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "time (ms)",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false
                );
        ChartPanel chartPanel = new ChartPanel(barGraph);
        chartPanel.setPreferredSize(new java.awt.Dimension(1050,750));
        setContentPane(chartPanel);
    }
    private CategoryDataset createDataset(){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<times.length;i++){
            for(int j=0;j<times[0].length;j++){
                String s = "Function "+Integer.toString(i);
                String t = "Trial "+ Integer.toString(j);
                dataset.addValue(times[i][j], t, s);
            }
        }
        return dataset;
    }
    protected static void createGUI(long[][] times){
        GUI chart = new GUI("","",times);
        chart.pack();
        chart.setVisible(true);
    }
}
