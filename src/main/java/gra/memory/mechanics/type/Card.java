package gra.memory.mechanics.type;

import javax.swing.*;
import java.awt.*;

public class Card implements Cloneable {

//    public static List<Card> cardsList = new ArrayList<>();
    private static int generalCardCounter = 0;

    private int cardId;
    private Image cardFrontCover;
    private Image cardBackCover;
    private JButton cardPlacingOnTable;

    public Card(Image cardFrontCover, Image cardBackCover, JButton cardPlacingOnTable) {
        setCardId();
        this.cardFrontCover = cardFrontCover;
        this.cardBackCover = cardBackCover;
        this.cardPlacingOnTable = cardPlacingOnTable;
    }

    public Card(Image cardFrontCover) {
        setCardId();
        this.cardFrontCover = cardFrontCover;
    }

    public Card() {
        setCardId();
    }

    private void setCardId() {
        this.cardId = generalCardCounter++;
    }

    public int getCardId() {
        return cardId;
    }

    public Image getCardFrontCover() {
        return cardFrontCover;
    }

    public Image getCardBackCover() {
        return cardBackCover;
    }

    public void setCardBackCover(Image cardBackCover) {
        this.cardBackCover = cardBackCover;
    }

    public JButton getCardPlacingOnTable() {
        return cardPlacingOnTable;
    }

    public void setCardPlacingOnTable(JButton cardPlacingOnTable) {
        this.cardPlacingOnTable = cardPlacingOnTable;
        this.cardPlacingOnTable.setOpaque(false);
        this.cardPlacingOnTable.setContentAreaFilled(false);
        this.cardPlacingOnTable.setBorderPainted(false);
    }

    @Override
    public Card clone() throws CloneNotSupportedException {
        return (Card) super.clone();
    }
}