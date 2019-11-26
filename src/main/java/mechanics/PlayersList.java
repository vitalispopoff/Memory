package mechanics;

import mechanics.type.Player;

import java.util.ArrayList;

public class PlayersList {

    public static ArrayList<Player> playerList = new ArrayList<>();


    public static void generatePlayers(int gracze){
        for (int i = 0; i <= gracze; i++) {
            StringBuilder name = new StringBuilder().append("Gracz ").append(Integer.toString(i));
            playerList.add(i,new Player(name.toString()));
            System.out.println(name.toString()+" added to playerList");

        }
        System.out.println(playerList.size());
    }
}
