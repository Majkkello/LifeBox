package GameModel.Environment;

/**
 * Created by esromic on 2018-01-21.
 */
public class PlantOrganism extends Organism {

    public PlantOrganism(int id, int size) {
        super(id, Math.random(), Math.random(), 0.0, 0.0, size);
    }
}
