package GameModel.Environment;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class PlantOrganism extends Organism {

    public PlantOrganism(int id, int size) {
        super(id, Math.random(), Math.random(), 0.0, 0.0, size);
        this.age = (int) (Math.random() * 150);
        lifeExpectancy = 150;
    }

    public void getDesiredCoords(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {

    }

    public void update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {

    }

}
