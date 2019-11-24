package mechanics.type;

import java.util.ArrayList;

public class Player {

    public static ArrayList<Player> playerList = new ArrayList<>();

    private String name;
    private int numberOfPoints = 0;


    public Player(String name) {
        this.name = name;
        playerList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public void addPoint (){
        numberOfPoints = numberOfPoints + 1;
    }

    public static void generatePlayers(int gracze){
        for (int i = 0; i <= gracze; i++) {
            StringBuilder name = new StringBuilder().append("Gracz ").append(Integer.toString(i));
            playerList.add(i,new Player(name.toString()));
            System.out.println(name.toString()+" added to playerList");

        }
    }

}
