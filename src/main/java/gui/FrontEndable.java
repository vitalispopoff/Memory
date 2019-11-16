package gui;

import javax.swing.*;

public interface FrontEndable {

    public JPanel MainPanel();

    /**
     * <code>LeftPanel()</code>
     * generuje lewy panel głównego okna,
     * który wyświetla rozdanie
    */
    public JPanel LeftPanel();

    /**
     * <code>RightPanel()</code>
     * generuje prawy panel głównego okna;
     * który wyświetla informacje o stanie gry
    */
    public JPanel RightPanel();

//    public default JButton populateCardGrid(){return null}

}
