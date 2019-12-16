package gui;

import static java.lang.Math.round;
import static mechanics.CardList.cardsList;
import static mechanics.type.Music.playMusicAction;
import static mechanics.type.Music.stopMusicBackground;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

import mechanics.Comparison;
import mechanics.type.Card;
import mechanics.type.ComparisonStatus;

class CardPanel extends TemporalParent implements CardPaneling {

    private static int[] ColumnsAndRowsOfCardGrid = {4, 4};      // 7, 8
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
    }

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
                cardsList.add(new Card(cardGraphicsList.getFrontImagesList().get(i).getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH))
                );

            for (int i = 0; i < (totalNumberOfCardsInGame >> 1); i++)
                cardsList.add(cardsList.get(i).clone());

            Collections.shuffle(cardsList);     // [TODO] does the SHovELIN'!

            for (int i = 0; i < cardsList.size(); i++) {
                final int i_final = i;
                cardsList.get(i).setCardPlacingOnTable(new JButton());
                cardsList.get(i).getCardPlacingOnTable().setOpaque(false);
                cardsList.get(i).getCardPlacingOnTable().setContentAreaFilled(false);
                cardsList.get(i).getCardPlacingOnTable().setBorderPainted(false);
                cardsList.get(i).setCardBackCover(sheet);
                cardsList.get(i).getCardPlacingOnTable().setIcon(new ImageIcon(cardsList.get(i).getCardBackCover()));
                cardsList.get(i).getCardPlacingOnTable().addActionListener(
                        e -> {
                            numberOfChoicesCurrentlyMade++;
                            if (numberOfChoicesCurrentlyMade < 3) {
                                cardsList.get(i_final).getCardPlacingOnTable().setIcon(new ImageIcon(cardsList.get(i_final).getCardFrontCover()));
                                cardsComparison(cardsList.get(i_final));
                                playMusicAction();
                            }
                        });
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < totalNumberOfCardsInGame; i++)
            add(cardsList.get(i).getCardPlacingOnTable());
    }

    public void cardsComparison(Card card) {
        comparison.compare(card);
        if (comparison.getComparisonStatus() == ComparisonStatus.WAIT)
            numberOfChoicesCurrentlyMade = 1;

        if (comparison.getComparisonStatus() == ComparisonStatus.TRUE) {
            InfoPanel.playerPoints[InfoPanel.isPlayer_2Move ? 1 : 0] += 1;
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
                            if (numberOfCardsStillOnTable == 0) stopMusicBackground();
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