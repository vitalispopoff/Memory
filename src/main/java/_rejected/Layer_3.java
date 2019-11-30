package _rejected;

import mechanics.Comparison;
import mechanics.type.Card;
import mechanics.type.ComparisonStatus;

import static mechanics.PlayersList.playerList;
import static mechanics.TurnChange.changePlayer;
import static mechanics.TurnChange.getCurrentPlayer;

import javax.swing.*;

import static gui.MainFrame.*;

public class Layer_3{

    private static JPanel panel3;
    private static JPanel panel3Left = new JPanel();
    private static JPanel panel3Right = new JPanel();
    int[] panel3LeftBounds = {
            tile >> 5,
            tile >> 5,
            tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    int[] panel3RightBounds = {
            tile_x - (tile_x >> 2) - (tile >> 3),
            tile >> 5,
            (tile_x >> 2) + (tile >> 3),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    private Comparison comparison = new Comparison();
    final int[] clickCounter = {0};



   /* public Layer_3() {
        panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setBounds(0, 0, tile_x, tile_y);
        panel3.setLayout(null);

        {
            panel3Left.setBounds(panel3LeftBounds[0], panel3LeftBounds[1], panel3LeftBounds[2], panel3LeftBounds[3]);
            panel3Left.setLayout(new GridLayout(cardGridSize[0], cardGridSize[1]));
            panel3Left.setOpaque(false);
            makeCardButtons();
            panel3.add(panel3Left);
        }

        {
            panel3Right.setBounds(panel3RightBounds[0], panel3RightBounds[1], panel3RightBounds[2], panel3RightBounds[3]);
            panel3Right.setLayout(null);
            panel3Right.setOpaque(false);
            panel3.add(panel3Right);
        }
    }*/

    public static JPanel makeLayer_3() {
        new Layer_3();
        return panel3;
    }

    /*public void makeCardButtons() {

        for (int i = 0; i < cardGridSize[0] * cardGridSize[1]; i++) {
            getCardsList().getCardFromList(i).getjButton().setOpaque(true);
            getCardsList().getCardFromList(i).getjButton().setContentAreaFilled(false);
            getCardsList().getCardFromList(i).getjButton().setBorderPainted(false);
            final int i_final = i;
            getCardsList().getCardFromList(i).getjButton().addActionListener(e -> {
                clickCounter[0] = clickCounter[0] + 1;
                if (clickCounter[0] < 3) {
                    playMusicAction("src\\main\\resources\\SFX\\flipCard2.wav");
                    getCardsList().getCardFromList(i_final).getjLabel().setIcon(new ImageIcon(getCardsList().getCardFromList(i_final).getFront()));
                    cardsComparison(getCardsList().getCardFromList(i_final));
                }
            });
            panel3Left.add(getCardsList().getCardFromList(i).getjButton());
            leftPanelButtons.add(getCardsList().getCardFromList(i).getjButton());
        }
    }*/

    public void cardsComparison(Card card){
        comparison.compare(card);

        if (comparison.getComparisonStatus()== ComparisonStatus.WAIT)
            clickCounter[0] =1;

        if (comparison.getComparisonStatus()==ComparisonStatus.TRUE){
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getjButton().setVisible(false);
                            comparison.getCard1().getjLabel().setVisible(false);
                            comparison.getCard2().getjButton().setVisible(false);
                            comparison.getCard2().getjLabel().setVisible(false);
                            clickCounter[0]=0;
                        }
                    },
                    1000

            );

            playerList.get(getCurrentPlayer()).addPoint();
            System.out.println(playerList.get(getCurrentPlayer()).getName() + " " + playerList.get(getCurrentPlayer()).getNumberOfPoints());


        } else if (comparison.getComparisonStatus()==ComparisonStatus.FALSE){

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getjLabel().setIcon(new ImageIcon(card.getBack()));
                            comparison.getCard2().getjLabel().setIcon(new ImageIcon(card.getBack()));
                            clickCounter[0]=0;
                        }
                    },
                    1000
            );
            System.out.println(playerList.get(getCurrentPlayer()).getName());

        }
        changePlayer(comparison.getComparisonStatus());
    }

}
