package mechanics.type;

import javax.swing.*;
import java.awt.*;

public class Card implements Cloneable {

/*
    public static List<Card> cardsList = new ArrayList<>(); 
*/ // ? disposable ?
    
    private static int 
        generalCardCounter = 0;

    private int 
        cardId;

    private final Image
        cardFrontCover;

    private Image
        cardBackCover;
    
    private JButton 
        cardPlacingOnTable;
    


    public Card(Image i) {
        
        setCardId();
        cardFrontCover = i;
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

    public void setCardPlacingOnTable(JButton b) {

        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        
        cardPlacingOnTable = b;
    }



    @Override
    public Card clone() throws CloneNotSupportedException {

        return (Card) super.clone();
    }
}