package mechanics;

import mechanics.type.*;

public class Comparison {

    private Card card1;
    private Card card2;
    private ComparisonStatus comparisonStatus;

    public Card getCard1() {
        return card1;
    }

/*    public void setCard1(Card card1) {
        this.card1 = card1;
    }*/

    public Card getCard2() {
        return card2;
    }

/*    public void setCard2(Card card2) {
        this.card2 = card2;
    }*/

    public ComparisonStatus getComparisonStatus() {
        return comparisonStatus;
    }

    /*public void setComparisonStatus(ComparisonStatus comparisonStatus) {
        this.comparisonStatus = comparisonStatus;
    }*/

    public void compare(Card card){

        if (card1!=null & card2!=null){
            card1=null;
            card2=null;
        }

        if (card1==null) {
            this.card1 = card;

            comparisonStatus = ComparisonStatus.WAIT;

        }
        else {
            this.card2 = card;
            comparisonStatus = null;
        }

        if (card1!=null & card2!=null) {
            if (card1.getCardId() == card2.getCardId() && card1!=card2) {
                comparisonStatus = ComparisonStatus.TRUE;

            } else if (card1.getCardId() == card2.getCardId() && card1==card2){
                card2 = null;
                comparisonStatus = ComparisonStatus.WAIT;
            }
            else{
                comparisonStatus = ComparisonStatus.FALSE;
            }
        }
    }
}
