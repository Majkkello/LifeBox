package GameModel.Environment;

import View.ModelEnvironmentObserver;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class Environment {
    private final double widthX = 1.0;
    private final double heightY = 1.0;
    private final int updateNumberPeriod = 100;
    private int crrUpdateTime = 0;
    private ArrayList<HerbivoreOrganism> herbivores = new ArrayList<>();
    private ArrayList<PlantOrganism> plants = new ArrayList<>();
    private int crrId = 0;
    private ArrayList<ModelEnvironmentObserver> observerApps = new ArrayList<>();

    public Environment(int herbivoresNum, int plantsNum) {
        for (int i = 0; i < herbivoresNum; ++i) {
            herbivores.add(new HerbivoreOrganism(crrId, 5 + (int) (Math.random() * 5)));
            crrId++;
        }
        for (int j = 0; j < plantsNum; ++j) {
            plants.add(new PlantOrganism(crrId, 2 + (int) (Math.random() * 2)));
            crrId++;
        }
    }

    public void update() {
        ArrayList<HerbivoreOrganism> newHerbivores = new ArrayList<>();
        ArrayList<PlantOrganism> newPlants = new ArrayList<>();
        // TODO: add eating plants
        // TODO: add reasoning in taking a path
        ArrayList<HerbivoreOrganism> newDeadHerbivores = new ArrayList<>();
        ArrayList<PlantOrganism> newDeadPlants = new ArrayList<>();
        // adds new born animals

        for (HerbivoreOrganism org : herbivores) {
            Organism newBorn = org.update(herbivores, plants, crrId);
            if (newBorn != null) {
                crrId++;
                newHerbivores.add((HerbivoreOrganism) newBorn);
            }
            if (crrUpdateTime == updateNumberPeriod - 1) {
                org.incrementAge();
            }
            if (!org.isAlive()) {
                newDeadHerbivores.add(org);
            }
        }
        for (PlantOrganism org : plants) {
            org.update(herbivores, plants, crrId);
            if (crrUpdateTime == updateNumberPeriod - 1) {
                org.incrementAge();
            }
            if (!org.isAlive()) {
                newDeadPlants.add(org);
            }
        }
        if (Math.random() < 0.01) {
            PlantOrganism newPlant = new PlantOrganism(crrId, 2 + (int) (Math.random() * 2));
            newPlants.add(newPlant);
            crrId++;
        }
        // removes dead elements and notifies observers

        // adds new created elements and notifies observers about them
        herbivores.addAll(newHerbivores);
        plants.addAll(newPlants);

        for (ModelEnvironmentObserver obs : observerApps) {
            obs.updateState(newHerbivores, newPlants, newDeadHerbivores, newDeadPlants);
        }

        herbivores.removeAll(newDeadHerbivores);
        plants.removeAll(newDeadPlants);

        crrUpdateTime = (crrUpdateTime + 1) % updateNumberPeriod;
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
