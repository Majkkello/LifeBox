package GameModel.Environment;

import View.ModelEnvironmentObserver;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class Environment {
    private final double widthX = 1.0;
    private final double heightY = 1.0;
    private ArrayList<HerbivoreOrganism> herbivores = new ArrayList<>();
    private ArrayList<PlantOrganism> plants = new ArrayList<>();
    private int crrId = 0;
    private ArrayList<ModelEnvironmentObserver> observerApps = new ArrayList<>();

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
        ArrayList<HerbivoreOrganism> newHerbivores = new ArrayList<>();
        ArrayList<PlantOrganism> newPlants = new ArrayList<>();
        // TODO: add dying functionality
        ArrayList<HerbivoreOrganism> newDeadHerbivores = new ArrayList<>();
        ArrayList<PlantOrganism> newDeadPlants = new ArrayList<>();
        // adds new born animals

        for (Organism org : herbivores) {
            org.update();
        }
        for (Organism org : plants) {
            org.update();
        }
        if (Math.random() < 0.01) {
            PlantOrganism newPlant = new PlantOrganism(crrId);
            plants.add(newPlant);
            newPlants.add(newPlant);
            crrId++;
        }
        // adds new created elements and notifies observers about them
        for (ModelEnvironmentObserver obs : observerApps) {
            obs.updateState(newHerbivores, newPlants);
        }
    }

    public void addObserverApp(ModelEnvironmentObserver obs) {
        observerApps.add(obs);
    }

    public void removeObserverApp(ModelEnvironmentObserver obs) {
        observerApps.remove(obs);
    }

    public void notifyObservers() {

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
