package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

import mechanics.Comparison;
import mechanics.type.Card;
import mechanics.type.ComparisonStatus;

import static java.lang.Math.round;
import static mechanics.CardList.cardsList;
import static mechanics.type.Music.playMusicAction;
import static mechanics.type.Music.stopMusicBackground;

class CardPanel extends TemporalParent implements CardPaneling{

    private CardGraphicsList cardGraphicsList = new CardGraphicsList();
    private int clickCounter = 0;
    private Comparison comparison = new Comparison();

    private static int[] cardPanelGridDimensions = {4, 4};      // 7, 8
    private static int numberOfCards = (cardPanelGridDimensions[0] * cardPanelGridDimensions[1]);

    private static int tricks = numberOfCards;
    private int[] cardPanelGridSizes = {
            (int) round((double) cardPanelBounds[2] / (double) cardPanelGridDimensions[0]),
            (int) round((double) cardPanelBounds[3] / (double) cardPanelGridDimensions[1])};
    private int cardSize;

    {
        int cache = Integer.min(cardPanelGridSizes[0], cardPanelGridSizes[1]);
        cardSize = cache - (cache >> 2);
    }

    CardPanel() {
        super();
        setLayout(new GridLayout(
                cardPanelGridDimensions[0],
                cardPanelGridDimensions[1])
        );
        setBounds(
                cardPanelBounds[0],
                cardPanelBounds[1],
                cardPanelBounds[2],
                cardPanelBounds[3]
        );
//        setOpaque(false);
        dealTheCards();
    }


    public void dealTheCards() {
        clickCounter = 0;
        Image sheet = new ImageIcon("src\\main\\resources\\cardCover.png")
                .getImage().getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH
                );
        try {

            for (int i = 0; i < (numberOfCards >> 1); i++) {
                cardsList.add(new Card(cardGraphicsList.getFrontImagesList().get(i).getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH))
                );
            }
            for (int i = 0; i < (numberOfCards >> 1); i++) {
                cardsList.add(cardsList.get(i).clone());
            }

            Collections.shuffle(cardsList);     // (TODO) SHUFFELIN'!

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
                            clickCounter++;
                            if (clickCounter < 3) {
                                cardsList.get(i_final).getCardPlacingOnTable().setIcon(new ImageIcon(cardsList.get(i_final).getCardFrontCover()));
                                cardsComparison(cardsList.get(i_final));
                                playMusicAction();
                            }
                        });
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < numberOfCards; i++) {
            add(cardsList.get(i).getCardPlacingOnTable());
        }
    }

    public void cardsComparison(Card card) {
        comparison.compare(card);
        if (comparison.getComparisonStatus() == ComparisonStatus.WAIT)
            clickCounter = 1;

        if (comparison.getComparisonStatus() == ComparisonStatus.TRUE) {
            InfoPanel.playerPoints[InfoPanel.isPlayer_2Move ? 1 : 0] += 1;
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getCardPlacingOnTable().setVisible(false);
                            comparison.getCard2().getCardPlacingOnTable().setVisible(false);
                            clickCounter = 0;
                            tricks -= 2;

                            InfoPanel.updateScoreBoard();
                            InfoPanel.refreshPointers();
                            if (tricks == 0) {
                                stopMusicBackground();
                            }
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
                            clickCounter = 0;
                            InfoPanel.isPlayer_2Move = !(InfoPanel.isPlayer_2Move);
                            InfoPanel.refreshPointers();
                        }
                    },
                    1000
            );
        }
    }
}
