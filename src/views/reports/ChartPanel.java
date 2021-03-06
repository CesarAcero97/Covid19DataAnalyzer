package views.reports;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {
    private ArrayList<Integer> values;
    private ArrayList<String> names;
    private String title;
    private JFrame frame;

    public ChartPanel(HashMap<String, Integer> data, String title) {
        frame = new JFrame();
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(this);
        this.title = title;
        names = new ArrayList<>();
        values = new ArrayList<>();
        hashMapEntry(data);
    }

    private void hashMapEntry(HashMap<String, Integer> data){
        data.forEach((k, v) -> {
            names.add(k);
            values.add(v);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values == null || values.size() == 0)
            return;
        double minValue = 0;
        double maxValue = 0;
        for (int i = 0; i < values.size(); i++) {
            if (minValue > values.get(i))
                minValue = values.get(i);
            if (maxValue < values.get(i))
                maxValue = values.get(i);
        }

        Dimension d = getSize();
        int clientWidth = d.width;
        int clientHeight = d.height;
        int barWidth = clientWidth / values.size();

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        int titleWidth = titleFontMetrics.stringWidth(title);
        int y = titleFontMetrics.getAscent();
        int x = (clientWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, x, y);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue)
            return;
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        y = clientHeight - labelFontMetrics.getDescent();
        g.setFont(labelFont);

        for (int i = 0; i < values.size(); i++) {
            int valueX = i * barWidth + 1;
            int valueY = top;
            int height = (int) (values.get(i) * scale);
            if (values.get(i) >= 0)
                valueY += (int) ((maxValue - values.get(i)) * scale);
            else {
                valueY += (int) (maxValue * scale);
                height = -height;
            }

            g.setColor(Color.blue);
            g.fillRect(valueX, valueY + 20, barWidth - 80, height-20 );
            g.setColor(Color.black);
            g.drawRect(valueX, valueY + 20, barWidth - 80, height-20 );
            int labelWidth = labelFontMetrics.stringWidth(names.get(i));
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names.get(i), x, y);
        }
    }
}