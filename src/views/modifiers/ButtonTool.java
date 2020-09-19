package views.modifiers;

import views.ConstantsUI;

import javax.swing.*;
import java.awt.*;

public class ButtonTool extends JButton {

    private Color hoverBackgroundColor = ConstantsUI.BUTTON_BG_COLOR;
    private Color pressedBackgroundColor = ConstantsUI.BUTTON_BG_COLOR;

    public ButtonTool(){
        super();
        setBackground(ConstantsUI.BUTTON_BG_COLOR);
        setForeground(ConstantsUI.BUTTON_FG_COLOR);
    }

    public ButtonTool(String text){
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}