package Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;


public class LineChart extends JFrame {
    String series1;
    String series2;
    String series3;
    String xLabel;
    String yLabel;
    int[] xS1Values;
    double[] yS1Values;
    double[] yS2Values;
    double[] yS3Values;


    public LineChart(String series1, int[] xS1Values, String xLabel,  double[] yS1Values, String yLabel){
        this.series1 = series1;
        this.xS1Values = xS1Values;
        this.xLabel = xLabel;
        this.yS1Values = yS1Values;
        this.yLabel = yLabel;
    }
    //Overloaded method for 2 series line chart
    public LineChart(String series1, String series2, int[] xS1Values, String xLabel,  double[] yS1Values, double[] yS2Values, String yLabel){
        this.series1 = series1;
        this.series2 = series2;
        this.xS1Values = xS1Values;
        this.xLabel = xLabel;
        this.yS1Values = yS1Values;
        this.yS2Values = yS2Values;
        this.yLabel = yLabel;
    }
    public LineChart(String series1, String series2, String series3, int[] xS1Values,  String xLabel,  double[] yS1Values, double[] yS2Values, double[] yS3Values, String yLabel){
        this.series1 = series1;
        this.series2 = series2;
        this.series3 = series3;
        this.xS1Values = xS1Values;
        this.xLabel = xLabel;
        this.yS1Values = yS1Values;
        this.yS2Values = yS2Values;
        this.yS3Values = yS3Values;
        this.yLabel = yLabel;
    }

    public JPanel createChartPanel(String series1, int[] xS1Values, double[] yS1Values){
        CategoryDataset dataset = createDataset(series1, xS1Values, yS1Values);
        JFreeChart chart = ChartFactory.createLineChart(series1, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, false,false,false);
        return new ChartPanel(chart);
    }

    //Overloaded method for 2 series line chart
    public JPanel createChartPanel(String title, String series1, String series2,  int[] xS1Values, double[] yS1Values, double[] yS2Values){
        CategoryDataset dataset = createDataset(series1, series2, xS1Values, yS1Values, yS2Values);
        JFreeChart chart = ChartFactory.createLineChart(title, xLabel, yLabel, dataset, PlotOrientation.VERTICAL, true,false,false);
        return new ChartPanel(chart);
    }

    public JPanel createChartPanel(String title, String series1, String series2, String series3,  int[] xS1Values, double[] yS1Values, double[] yS2Values, double[] yS3Values){
        CategoryDataset dataset = createDataset(series1, series2, series3, xS1Values, yS1Values, yS2Values, yS3Values);
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
    public CategoryDataset createDataset(String series1,String series2, int[] xS1Values, double[] yS1Values, double[] yS2Values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int[] shortX = new int [(xS1Values.length / 3)+1];
        double[] shortYS1 = new double [(yS1Values.length/3)+1];
        double[] shortYS2 = new double [(yS2Values.length/3)+1];

        //Reduce array size by 1/3 to fit all labels on chart
        if (xS1Values.length >= 31) {
            for (int j = 0; j < shortX.length; j++) {
                if(j != shortX.length-1){
                    shortX[j] = xS1Values[j*3];
                    shortYS1[j] = yS1Values[j*3];
                    shortYS2[j] = yS2Values[j*3];
                }
                shortX[shortX.length-1] = xS1Values[xS1Values.length-1];
                shortYS1[shortYS1.length-1] = yS1Values[yS1Values.length-1];
                shortYS2[shortYS2.length-1] = yS2Values[yS2Values.length-1];

            }
            for (int i = 0; i < shortX.length; i++) {
                dataset.addValue(shortYS1[i], series1, String.valueOf(shortX[i]));
                dataset.addValue(shortYS2[i], series2, String.valueOf(shortX[i]));
            }
        }

        if (xS1Values.length <= 30) {
            for (int i = 0; i < xS1Values.length; i++) {
                dataset.addValue(yS1Values[i], series1, String.valueOf(xS1Values[i]));
                dataset.addValue(yS2Values[i], series2, String.valueOf(xS1Values[i]));
            }
        }
        return dataset;
    }


    public CategoryDataset createDataset(String series1, String series2, String series3, int[] xS1Values, double[] yS1Values, double[] yS2Values, double[] yS3Values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int[] shortX = new int [(xS1Values.length / 3)+1];
        double[] shortYS1 = new double [(yS1Values.length/3)+1];
        double[] shortYS2 = new double [(yS2Values.length/3)+1];
        double[] shortYS3 = new double [(yS3Values.length/3)+1];

        //Reduce array size by 1/3 to fit all labels on chart
        if (xS1Values.length >= 31) {
            for (int j = 0; j < shortX.length; j++) {
                if(j != shortX.length-1){
                    shortX[j] = xS1Values[j*3];
                    shortYS1[j] = yS1Values[j*3];
                    shortYS2[j] = yS2Values[j*3];
                    shortYS3[j] = yS3Values[j*3];
                }
                shortX[shortX.length-1] = xS1Values[xS1Values.length-1];
                shortYS1[shortYS1.length-1] = yS1Values[yS1Values.length-1];
                shortYS2[shortYS2.length-1] = yS2Values[yS2Values.length-1];
                shortYS3[shortYS3.length-1] = yS3Values[yS3Values.length-1];
            }
            for (int i = 0; i < shortX.length; i++) {
                dataset.addValue(shortYS1[i], series1, String.valueOf(shortX[i]));
                dataset.addValue(shortYS2[i], series2, String.valueOf(shortX[i]));
                dataset.addValue(shortYS3[i], series3, String.valueOf(shortX[i]));
            }
        }

        if (xS1Values.length <= 30) {
            for (int i = 0; i < xS1Values.length; i++) {
                dataset.addValue(yS1Values[i], series1, String.valueOf(xS1Values[i]));
                dataset.addValue(yS2Values[i], series2, String.valueOf(xS1Values[i]));
                dataset.addValue(yS3Values[i], series3, String.valueOf(xS1Values[i]));
            }
        }
        return dataset;
    }


}
