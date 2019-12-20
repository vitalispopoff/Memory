package gra.memory.mechanics;

import game.memory.mechanics.type.*;
import gra.memory.mechanics.type.Card;
import gra.memory.mechanics.type.ComparisonStatus;

public class Comparison implements Comparisonable {

    private Card card1;
    private Card card2;
    private ComparisonStatus comparisonStatus;

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public ComparisonStatus getComparisonStatus() {
        return comparisonStatus;
    }

    @Override
    public void compare(Card card) {

        if (card1 != null & card2 != null) {
            card1 = null;
            card2 = null;
        }
        if (card1 == null) {
            this.card1 = card;
            comparisonStatus = ComparisonStatus.WAIT;
        }
        else {
            this.card2 = card;
            comparisonStatus = null;
        }

        if (card1 != null & card2 != null) {
            if (card1.getCardId() == card2.getCardId() && card1 != card2)
                comparisonStatus = ComparisonStatus.TRUE;
            else if (card1.getCardId() == card2.getCardId() && card1 == card2) {
                card2 = null;
                comparisonStatus = ComparisonStatus.WAIT;
            }
            else comparisonStatus = ComparisonStatus.FALSE;

        }
    }
}
