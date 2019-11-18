package _rejected;

import javax.swing.*;

public interface FrontEndable {

    public static JPanel MainPanel(){return new JPanel();}

    /**
     * <code>LeftPanel()</code>
     * generuje lewy panel głównego okna,
     * który wyświetla rozdanie
    */
    public default JPanel LeftPanel(){return new JPanel();}

    /**
     * <code>RightPanel()</code>
     * generuje prawy panel głównego okna;
     * który wyświetla informacje o stanie gry
    */
    public default JPanel RightPanel(){return new JPanel();}

//    public default JButton populateCardGrid(){return null}

}
