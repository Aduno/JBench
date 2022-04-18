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
    private GUI(String title, String chartTitle, long[][] times, int x, int y, boolean avg, PView.Time scale){
        super(title);
        this.times= times;
        JFreeChart barGraph = ChartFactory.createBarChart(
                chartTitle,
                avg? "Averaged Function": "Function",
                "time ("+scale+")",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false
                );
        ChartPanel chartPanel = new ChartPanel(barGraph);
        chartPanel.setPreferredSize(new java.awt.Dimension(x,y));
        setContentPane(chartPanel);
    }
    private CategoryDataset createDataset(){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<times.length;i++){
            for(int j=0;j<times[0].length;j++){
                String s = "Function "+Integer.toString(i+1);
                String t = "Trial "+ Integer.toString(j+1);
                dataset.addValue(times[i][j], t, s);
            }
        }
        return dataset;
    }
    protected static void createGUI(long[][] times, int x, int y, boolean average, PView.Time scale){
        GUI chart = new GUI("JBench","",times, x, y, average, scale);
        chart.pack();
        chart.setVisible(true);
    }
}
