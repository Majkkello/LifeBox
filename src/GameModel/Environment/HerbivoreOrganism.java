package GameModel.Environment;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class HerbivoreOrganism extends Organism {

    private final double interactionDistance = 0.001;

    private double hungerCoefficient;
    private double matingCoefficient;
    private double hungerLevel;
    private boolean matedRecently;

    public HerbivoreOrganism(int id, int size) {
        super(id, Math.random(), Math.random(), 0.0002, 0.0002, size);
        this.age = (int) (Math.random() * 100);
        this.hungerLevel = Math.random() / 1.1;
        lifeExpectancy = 100;
        hungerCoefficient = Math.random();
        matingCoefficient = Math.random();
        eyeSight = 0.2;
        matedRecently = false;
    }

    public Coords getDesiredCoords(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {
        double maxResult = 0.0;
        double distance;
        double func;
        Coords desired = new Coords(-1.0, -1.0);
        if (!matedRecently) {
            for (HerbivoreOrganism org : herbivores) {
                if (!org.matedRecently) {
                    distance = getDistanceTo(org);
                    if (distance < this.eyeSight) {
                        if (distance < interactionDistance) {

                        }
                        else {
                            func = matingCoefficient * (1.0 - distance);
                            if (func > maxResult) {
                                desired = new Coords(org.positionX, org.positionY);
                            }
                        }
                    }
                }
            }
        }
        for (PlantOrganism org : plants) {
            distance = getDistanceTo(org);
            if (distance < this.eyeSight) {
                if (distance < interactionDistance) {

                }
                else {
                    func = ((hungerCoefficient + hungerLevel) / 2.0) * (1.0 - distance);
                    if (func > maxResult) {
                        desired = new Coords(org.positionX, org.positionY);
                    }
                }

            }
        }
        return desired;
    }

    @Override
    public void update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {

        getDesiredCoords(herbivores, plants);

        if ((positionX <= 0.01 && velocityX < 0.0) || (positionX >= 0.99 && velocityX > 0.0)) {
            velocityX = 0.0;
        }
        if ((positionY <= 0.01 && velocityY < 0.0) || (positionY >= 0.99 && velocityY > 0.0)) {
            velocityY = 0.0;
        }

        positionX += velocityX;
        positionY += velocityY;

        velocityX += (Math.random() - 0.5) / 10000.0;
        velocityY += (Math.random() - 0.5) / 10000.0;
    }

    @Override
    public void incrementAge() {
        super.incrementAge();
        matedRecently = false;
    }
}
