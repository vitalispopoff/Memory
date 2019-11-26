package mechanics;
import gui.CardGraphicsLists;



public class Play {
    private static CardLists cardsList = new CardLists();
    private static CardGraphicsLists cardGraphicsLists = new CardGraphicsLists();

    public static CardLists getCardsList() {
        return cardsList;
    }

    public static void setCardsList(CardLists cardsList) {
        Play.cardsList = cardsList;
    }

    public static CardGraphicsLists getCardGraphicsLists() {
        return cardGraphicsLists;
    }

    public static void setCardGraphicsLists(CardGraphicsLists cardGraphicsLists) {
        Play.cardGraphicsLists = cardGraphicsLists;
    }


}
