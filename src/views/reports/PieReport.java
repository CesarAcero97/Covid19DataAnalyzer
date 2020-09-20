package views.reports;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
public class PieReport extends JFrame {

    public PieReport(String title, HashMap<String, Integer> data) {
        super(title);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        PieDataset dataset = hashMapToDataSet(data);
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private PieDataset hashMapToDataSet(HashMap<String, Integer> data) {
        DefaultPieDataset pieData = new DefaultPieDataset();
        data.forEach((k, v) -> {
            pieData.setValue(k, v);
        });
        return pieData;
    }
}