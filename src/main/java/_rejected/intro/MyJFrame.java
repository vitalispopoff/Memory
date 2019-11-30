package _rejected.intro;

import javax.swing.*;

public class MyJFrame extends JFrame {

    public MyJFrame()  {

        setUndecorated(true);
        MyJPanelIntro myJPanelIntro = new MyJPanelIntro();
        add(myJPanelIntro);
    }
}
