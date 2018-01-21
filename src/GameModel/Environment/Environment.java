package GameModel.Environment;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by esromic on 2018-01-21.
 */
public class Environment {
    private final double widthX = 1.0;
    private final double heightY = 1.0;
    private ArrayList<HerbivoreOrganism> herbivores = new ArrayList<>();
    private ArrayList<PlantOrganism> plants = new ArrayList<>();
    private int crrId = 0;

    public Environment(int herbivoresNum, int plantsNum) {
        for (int i = 0; i < herbivoresNum; ++i) {
            herbivores.add(new HerbivoreOrganism(crrId));
            crrId++;
        }
        for (int j = 0; j < plantsNum; ++j) {
            plants.add(new PlantOrganism(crrId));
            crrId++;
        }
    }

    public void update() {
        for (Organism org : herbivores) {
            org.update();
        }
        for (Organism org : plants) {
            org.update();
        }
        if (Math.random() > 0.001){
            plants.add(new PlantOrganism(crrId));
            crrId++;
        }
    }

    public double getWidthX() {
        return widthX;
    }

    public double getHeightY() {
        return heightY;
    }

    public ArrayList<HerbivoreOrganism> getHerbivores() {
        return herbivores;
    }

    public ArrayList<PlantOrganism> getPlants() {
        return plants;
    }
}
