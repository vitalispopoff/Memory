package mechanics.type;

import javax.swing.*;
import java.awt.*;

public class Card implements Cloneable {

    private Image front;
    private Image back;
    private int cardId;
    private static  int lastId = 0;
    private JButton jButton;

    public Card(Image front, Image back, int cardId, JButton jButton) {
        this.front = front;
        this.back = back;
        this.cardId = cardId;
        this.jButton = jButton;
    }

    public Card(Image front) {
        this.front = front;
        lastId++;
        this.cardId = lastId;
    }

    public Card (){}

    public Image getFront() {
        return front;
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

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    @Override
    public Card clone() throws CloneNotSupportedException {
        return (Card) super.clone();
    }

}
