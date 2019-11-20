package mechanics.type;

import javax.swing.*;
import java.awt.*;

public class Card implements Cloneable {

    private Image front;
    private Image back;
    private int cardId;
    private JButton jButton;
    private JLabel jLabel;

    public Card(Image front, Image back, int cardId, JButton jButton, JLabel jLabel) {
        this.front = front;
        this.back = back;
        this.cardId = cardId;
        this.jButton = jButton;
        this.jLabel = jLabel;
    }

    public Card (){}


    public Image getFront() {
        return front;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public Image getBack() {
        return back;
    }

    public void setBack(Image back) {
        this.back = back;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public Card clone() throws CloneNotSupportedException {
        return (Card) super.clone();
    }

}
