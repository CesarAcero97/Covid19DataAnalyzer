package views.modifiers;

import javax.swing.border.Border;
import java.awt.*;

public class TableBorder implements Border {

    private int radio;

    public TableBorder(int radius) {
        this.radio = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radio+100, this.radio+1, this.radio+2, this.radio);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x+radio, y+radio, width-(radio*2), height-(radio*2), radio, radio);
    }

}