package mechanics;

import mechanics.type.Card;

import java.util.ArrayList;
import java.util.List;

public class CardLists {

    private List<Card> cardsList = new ArrayList<>();

    public CardLists() {
    }

    public List<Card> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    public void addCardToList (Card card){
        cardsList.add(card);
    }

    public Card getCardFromList(int index){
       return cardsList.get(index);
    }
}
