package gra.memory.mechanics;


import gra.memory.mechanics.type.Card;

public interface Comparisonable {

    /**
     * check :
     * 1) both cards found chosen => resets cards ;;
     * 2) 1st card found blank => chose 1st card, status: WAIT ;;
     * 3) [1st chosen, 2nd blank] => chose 2nd; reset status ;;
     *  then checks :
     *  4) both of cards are chosen :
     *  a) different entities with equal cardId
     *      => staus : TRUE ;;
     *  b) both are the same entity ( with the same cardId? is it really necessary? >TODO)
     *      => reset 2nd, status : WAIT ;;
     *  c) [different cardId]
     *      => status : FALSE.
    */
    void compare(Card card);


}
