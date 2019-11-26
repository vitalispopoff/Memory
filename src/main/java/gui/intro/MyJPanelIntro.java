package gui.intro;

import javax.swing.*;
import java.awt.*;

public class MyJPanelIntro extends JPanel {

    Image image;

    public MyJPanelIntro() {
        image = Toolkit.getDefaultToolkit().createImage("src\\main\\resources\\intro\\intro.gif");
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }


}
