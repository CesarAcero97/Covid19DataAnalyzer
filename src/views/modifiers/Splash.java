package views.modifiers;

import views.ConstantsUI;

import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow {

    private final int duration;

    public Splash(int d) {
        duration = d;
    }

    public void showSplash() {

        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);

        int width = 450;
        int height = 450;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);


        JLabel label = new JLabel();
        Image importIcon = (new ImageIcon(getClass().getResource("/resources/imgs/splashIcon.jpeg")).getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH));
        label.setIcon(new ImageIcon(importIcon));
        JLabel copyrt = new JLabel
                ("Cesar Acero & Orlando Rodriguez", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        copyrt.setForeground(Color.black);
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = Color.black;
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception ignored) {}

        setVisible(false);

    }
}