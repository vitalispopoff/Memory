package mechanics.type;

public class Player {

    private String name;
    private int numberOfPoints = 0;


    public Player(String name) {
        this.name = name;
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

}
