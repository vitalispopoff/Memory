package mechanics;
import gui.CardGraphicsLists;
import mechanics.type.*;



public class Play {
    private static Music musicForClick = new Music();
    private static CardLists cardsList = new CardLists();
    private static CardGraphicsLists cardGraphicsLists = new CardGraphicsLists();


    public static Music getMusicForClick() {
        return musicForClick;
    }

    public static void setMusicForClick(Music musicForClick) {
        Play.musicForClick = musicForClick;
    }

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
