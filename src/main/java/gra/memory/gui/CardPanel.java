package gra.memory.gui;

import static java.lang.Math.round;
import static gra.memory.mechanics.type.Music.playMusicAction;
import static gra.memory.mechanics.type.Music.stopMusicBackground;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

import gra.memory.gui.infoPanel.PlayerStatusPanel;
import gra.memory.mechanics.Comparison;
import gra.memory.mechanics.type.Card;
import gra.memory.mechanics.type.ComparisonStatus;
import gra.memory.mechanics.CardList;
import gra.memory.mechanics.type.Music;

class CardPanel extends TemporalParent implements CardPaneling {

    private static int[] ColumnsAndRowsOfCardGrid = {8, 7};      // 7, 8
    private static int totalNumberOfCardsInGame = (ColumnsAndRowsOfCardGrid[0] * ColumnsAndRowsOfCardGrid[1]);
    private static int numberOfCardsStillOnTable = totalNumberOfCardsInGame;

    private CardGraphicsList cardGraphicsList = new CardGraphicsList();
    private int numberOfChoicesCurrentlyMade = 0;
    private Comparison comparison = new Comparison();
    private int[] cardPanelGridSizes = {
            (int) round((double) cardPanelBounds[2] / (double) ColumnsAndRowsOfCardGrid[0]),
            (int) round((double) cardPanelBounds[3] / (double) ColumnsAndRowsOfCardGrid[1])};
    private int cardSize;
    {
        int cache = Integer.min(cardPanelGridSizes[0], cardPanelGridSizes[1]);
        cardSize = cache - (cache >> 2);
    }   // * defining cardsize

    CardPanel() {
        super();
        setLayout(new GridLayout(
                ColumnsAndRowsOfCardGrid[0],
                ColumnsAndRowsOfCardGrid[1])
        );
        setBounds(
                cardPanelBounds[0],
                cardPanelBounds[1],
                cardPanelBounds[2],
                cardPanelBounds[3]
        );
        dealTheCards();
    }

    public void dealTheCards() {
        numberOfChoicesCurrentlyMade = 0;
        Image sheet = new ImageIcon("src\\main\\resources\\cardCover.png")
                .getImage().getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH
                );
        try {
            for (int i = 0; i < (totalNumberOfCardsInGame >> 1); i++)
                CardList.listOfCards.add(new Card(cardGraphicsList.getFrontImagesList().get(i).getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH))
                );

            for (int i = 0; i < (totalNumberOfCardsInGame >> 1); i++)
                CardList.listOfCards.add(CardList.listOfCards.get(i).clone());

            Collections.shuffle(CardList.listOfCards);     // [TODO] does the SHovELIN'!

            for (int i = 0; i < CardList.listOfCards.size(); i++) {
                final int i_final = i;
                CardList.listOfCards.get(i).setCardPlacingOnTable(new JButton());
/*                listOfCards.get(i).getCardPlacingOnTable().setOpaque(false);
                listOfCards.get(i).getCardPlacingOnTable().setContentAreaFilled(false);
                listOfCards.get(i).getCardPlacingOnTable().setBorderPainted(false);*/
                CardList.listOfCards.get(i).setCardBackCover(sheet);
                CardList.listOfCards.get(i).getCardPlacingOnTable().setIcon(new ImageIcon(CardList.listOfCards.get(i).getCardBackCover()));
                CardList.listOfCards.get(i).getCardPlacingOnTable().addActionListener(
                        e -> {
                            numberOfChoicesCurrentlyMade++;
                            if (numberOfChoicesCurrentlyMade < 3) {
                                CardList.listOfCards.get(i_final).getCardPlacingOnTable().setIcon(new ImageIcon(CardList.listOfCards.get(i_final).getCardFrontCover()));
                                cardsComparison(CardList.listOfCards.get(i_final));
                                Music.playMusicAction();
                            }
                        });
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < totalNumberOfCardsInGame; i++)
            add(CardList.listOfCards.get(i).getCardPlacingOnTable());
    }

    public void cardsComparison(Card card) {
        comparison.compare(card);
        if (comparison.getComparisonStatus() == ComparisonStatus.WAIT)
            numberOfChoicesCurrentlyMade = 1;

        if (comparison.getComparisonStatus() == ComparisonStatus.TRUE) {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getCardPlacingOnTable().setVisible(false);
                            comparison.getCard2().getCardPlacingOnTable().setVisible(false);
                            numberOfChoicesCurrentlyMade = 0;
                            numberOfCardsStillOnTable -= 2;
                            PlayerStatusPanel.updateScoreBoard();
                            PlayerStatusPanel.refreshPointers();
                            if (numberOfCardsStillOnTable == 0) Music.stopMusicBackground();
                        }
                    },
                    1000
            );
        } else if (comparison.getComparisonStatus() == ComparisonStatus.FALSE) {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getCardPlacingOnTable().setIcon(new ImageIcon(card.getCardBackCover()));
                            comparison.getCard2().getCardPlacingOnTable().setIcon(new ImageIcon(card.getCardBackCover()));
                            numberOfChoicesCurrentlyMade = 0;
                            PlayerStatusPanel.setNextPlayer();
                            PlayerStatusPanel.refreshPointers();
                        }
                    },
                    1000
            );
        }
    }
}