package GameModel.Environment;

import View.ViewFX.Herbivore;

/**
 * Created by esromic on 2018-01-21.
 */
public class HerbivoreOrganism extends Organism {
    public HerbivoreOrganism(double positionX, double positionY, double velocityX, double velocityY, int size) {
        super(positionX, positionY, velocityX, velocityY, size);
    }
    public HerbivoreOrganism() {
        super(Math.random(), Math.random(), 0.001, 0.001, 10);
    }
}
