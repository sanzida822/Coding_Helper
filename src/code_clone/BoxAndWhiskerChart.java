
package code_clone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxAndWhiskerChart {
    
//  public static  ArrayList<Double> list = new ArrayList<>();
  ChartPanel chartPanel;

JScrollPane scrollPane;
  /*  public void GetCosineList() {

        for (int i = 0; i < CosineSimilarity.similarArray.size(); i++) {
         //   System.out.println("kk=" + CosineSimilarity.similarArray.get(i));
      getInputData(CosineSimilarity.similarArray.get(i));
            }

        }*/

    

    private List<Double> getInputData(double l[]) {
        ArrayList<Double> list = new ArrayList<>();
       // Scanner scan=new Scanner(Double l);
           // double a[] = CosineSimilarity.similarArray.get(i);
        
            for (int j = 0; j < l.length; j++) {
                double d=l[j];
     //    System.out.println("k=="+l[j]);
                list.add(l[j]);


        }//System.out.println("");
            return list;
        }

    

    public void display() {
        JFrame f = new JFrame("Clone_Check");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultBoxAndWhiskerCategoryDataset boxData = new DefaultBoxAndWhiskerCategoryDataset();
 
        for (int i=0;i<CosineSimilarity.similarArray.size();i++) {
           // System.out.println(""+getInputData(CosineSimilarity.similarArray.get(i)));
        
        }
        
        for (int i=0;i<CosineSimilarity.similarArray.size();i++) {
           // System.out.println("p="+CosineSimilarity.similarArray.g);
            boxData.add(getInputData(CosineSimilarity.similarArray.get(i)), "First_Project vs Second_Project", CloneCheck.ProjectFileName1.get(i));
        }
            BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
            renderer.setFillBox(true);
  //  renderer.setSeriesPaint(0, Color.white);
    //renderer.setSeriesPaint(1, Color.LIGHT_GRAY);
   // renderer.setSeriesOutlinePaint(0, Color.BLACK);
   // renderer.setSeriesOutlinePaint(1, Color.BLACK);
    renderer.setUseOutlinePaintForWhiskers(true);   
   // Font legendFont = new Font("SansSerif", Font.PLAIN, 16);
   // renderer.setLegendTextFont(0, legendFont);
  //  renderer.setLegendTextFont(1, legendFont);
   renderer.setMedianVisible(true);
     renderer.setMeanVisible(false);
    
            CategoryAxis xAxis = new CategoryAxis("First_Project_Files");
            NumberAxis yAxis = new NumberAxis("Second_Project_Values");
            CategoryPlot plot = new CategoryPlot(boxData, xAxis, yAxis, renderer);
            final JFreeChart chart = new JFreeChart(
                    "Box-and-Whisker Plot",
                    new Font("SansSerif", Font.BOLD, 20),
                    plot,
                    true
            );
            final ChartPanel chartPanel = new ChartPanel(chart);
            chart.setBackgroundPaint(Color.LIGHT_GRAY);
            //   JFreeChart chart = new JFreeChart("Test", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
            f.add(new ChartPanel(chart) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(600, 600);
                }
            });
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

    

    public static void BoxWhisker() {
        EventQueue.invokeLater(new BoxAndWhiskerChart()::display);
    }
}
