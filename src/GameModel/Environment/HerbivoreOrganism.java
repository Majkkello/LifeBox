package GameModel.Environment;

import View.ViewFX.Herbivore;

/**
 * Created by esromic on 2018-01-21.
 */
public class HerbivoreOrganism extends Organism {

    private final int lifeTimeExpectancy = 10;

    public HerbivoreOrganism(int id, int size) {
        super(id, Math.random(), Math.random(), 0.0002, 0.0002, size);
    }
}
