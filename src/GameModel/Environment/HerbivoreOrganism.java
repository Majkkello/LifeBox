package GameModel.Environment;

import View.ViewFX.Herbivore;

/**
 * Created by esromic on 2018-01-21.
 */
public class HerbivoreOrganism extends Organism {

    public HerbivoreOrganism(int id) {
        super(id, Math.random(), Math.random(), 0.001, 0.001, 10);
    }
}
