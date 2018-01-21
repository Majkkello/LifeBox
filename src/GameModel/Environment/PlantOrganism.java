package GameModel.Environment;

/**
 * Created by esromic on 2018-01-21.
 */
public class PlantOrganism extends Organism {
    public PlantOrganism(double positionX, double positionY, double velocityX, double velocityY, int size) {
        super(positionX, positionY, velocityX, velocityY, size);
    }
    public PlantOrganism() {
        super(Math.random(), Math.random(), 0.0, 0.0, 5);
    }
}
