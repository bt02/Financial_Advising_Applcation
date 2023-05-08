package Graphs;

import jdk.jfr.Category;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

public class LineChart extends JFrame {
    String series1;
    String series2;
    String xLabel;
    String yLabel;
    int[] xS1Values;
    int[] xS2Values;
    double[] yS1Values;
    double[] yS2Values;

    public String getSeries1() {
        return series1;
    }

    public String getSeries2() {
        return series2;
    }
    public int[] getxS1Values() {
        return xS1Values;
    }

    public int[] getxS2Values() {
        return xS2Values;
    }

    public double[] getyS1Values() {
        return yS1Values;
    }

    public double[] getyS2Values() {
        return yS2Values;
    }




    public LineChart(String series1, int[] xS1Values, String xLabel,  double[] yS1Values, String yLabel){
        this.series1 = series1;
        this.xS1Values = xS1Values;
        this.xLabel = xLabel;
        this.yS1Values = yS1Values;
        this.yLabel = yLabel;
    }
    //Overloaded method for 2 series line chart
    public LineChart(String series1, String series2, int[] xS1Values, int[] xS2Values, String xLabel,  double[] yS1Values, double[] yS2Values, String yLabel){
        this.series1 = series1;
        this.series2 = series2;
        this.xS1Values = xS1Values;
        this.xS2Values = xS2Values;
        this.xLabel = xLabel;
        this.yS1Values = yS1Values;
        this.yS2Values = yS2Values;
        this.yLabel = yLabel;
    }

    public JPanel createChartPanel(String series1, int[] xS1Values, double[] yS1Values){
        CategoryDataset dataset = createDataset(series1, xS1Values, yS1Values);
        JFreeChart chart = ChartFactory.createLineChart(series1, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, false,false,false);
        return new ChartPanel(chart);
    }

    //Overloaded method for 2 series line chart
    public JPanel createChartPanel(String title, String series1, String series2,  int[] xS1Values, int[] xS2Values, double[] yS1Values, double[] yS2Values){
        CategoryDataset dataset = createDataset(series1, series2, xS1Values, xS2Values, yS1Values, yS2Values);
        JFreeChart chart = ChartFactory.createLineChart(title, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, true,false,false);
        return new ChartPanel(chart);
    }

    public CategoryDataset createDataset(String series1, int[] xS1Values, double[] yS1Values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int[] shortX = new int [(xS1Values.length / 3)+1];
        double[] shortY = new double [(yS1Values.length/3)+1];

        //Reduce array size by 1/3 to fit all labels on chart
        if (xS1Values.length >= 31) {
            for (int j = 0; j < shortX.length; j++) {
                if(j != shortX.length-1){
                    shortX[j] = xS1Values[j*3];
                    shortY[j] = yS1Values[j*3];
                }
                shortX[shortX.length-1] = xS1Values[xS1Values.length-1];
                shortY[shortY.length-1] = yS1Values[yS1Values.length-1];
            }
            for (int i = 0; i < shortX.length; i++) {
                dataset.addValue(shortY[i], series1, String.valueOf(shortX[i]));
            }
        }

        if (xS1Values.length <= 30) {
            for (int i = 0; i < xS1Values.length; i++) {
                dataset.addValue(yS1Values[i], series1, String.valueOf(xS1Values[i]));
            }
        }
            return dataset;
    }

    //Overloaded method
    public CategoryDataset createDataset(String series1,String series2, int[] xS1Values, int[] xS2Values, double[] yS1Values, double[] yS2Values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int[] shortXS1 = new int [(xS1Values.length / 3)+1];
        double[] shortYS1 = new double [(yS1Values.length/3)+1];
        int[] shortXS2 = new int [(xS2Values.length / 3)+1];
        double[] shortYS2 = new double [(yS2Values.length/3)+1];

        for (int i = 0; i < xS1Values.length; i++) {
            dataset.addValue(yS1Values[i], series1, String.valueOf(xS1Values[i]));
            dataset.addValue(yS2Values[i], series2, String.valueOf(xS2Values[i]));
        }
        return dataset;
    }


}
