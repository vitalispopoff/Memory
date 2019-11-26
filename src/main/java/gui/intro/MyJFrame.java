package gui.intro;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame()  {

        setUndecorated(true);
        MyJPanelIntro myJPanelIntro = new MyJPanelIntro();
        add(myJPanelIntro);
    }
}
