package GameModel.Environment;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class PlantOrganism extends Organism {

    public PlantOrganism(int id, int size) {
        super(id, (Math.random() + 0.1) / 1.2, (Math.random() + 0.1) / 1.2, 0.0, 0.0, size);
        this.age = (int) (Math.random() * 150);
        lifeExpectancy = 150;
    }

    public void getDesiredCoords(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {

    }

    @Override
    public Organism update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants, int id) {
        return null;
    }

    @Override
    public String getType() {
        return "plant";
    }

    @Override
    public Organism createNewMember(Organism partner, int id) {
        return null;
    }

}
