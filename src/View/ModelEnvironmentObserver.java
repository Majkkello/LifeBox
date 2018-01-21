package View;

import GameModel.Environment.HerbivoreOrganism;
import GameModel.Environment.PlantOrganism;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public interface ModelEnvironmentObserver {
    void updateState(ArrayList<HerbivoreOrganism> newHerbibores,
                     ArrayList<PlantOrganism> newPlants,
                     ArrayList<HerbivoreOrganism> newDeadHerbivores,
                     ArrayList<PlantOrganism> newDeadPlants);
}
