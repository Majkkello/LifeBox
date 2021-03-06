package GameModel.Environment;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public class HerbivoreOrganism extends Organism {

    private final double interactionDistance = 1.0 / 100.0;
    private final double maxSpeed = (1 / ((double) size * 200));

    private double hungerCoefficient;
    private double matingCoefficient;
    private double nourishmentLevel;
    private boolean matedRecently;
    private int matingCount = 0;

    public HerbivoreOrganism(int id, int size) {
        super(id, Math.random(), Math.random(), 0.0, 0.0, size);
        this.age = (int) (Math.random() * 100);
        this.nourishmentLevel = Math.random();
        lifeExpectancy = 200;
        hungerCoefficient = 0.5 + Math.random() / 2.0;
        matingCoefficient = Math.random();
        eyeSight = (0.5 + Math.random() / 2.0) / 10.0;
        matedRecently = false;
    }

    // TODO: add mating function that prefers organisms to mate with similar to them - organisms divide into species
    public Organism getDesiredOrg(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants) {
        double maxResult = 0.0;
        double distance;
        double func;
        Organism desired = null;
        if ((!matedRecently) && this.age > 20) {
            for (HerbivoreOrganism org : herbivores) {
                if ((!org.matedRecently) && (org != this) && (org.age > 20)) {
                    distance = getDistanceTo(org);
                    if (distance < this.eyeSight) {
                        func = matingCoefficient * (1.0 - distance);
                        //System.out.println("Wanna mate?: " + func);
                        if (func > maxResult) {
                            maxResult = func;
                            //System.out.println("mating coeff: "+ func);
                            desired = org;//new Vector2D(org.positionX, org.positionY);
                        }
                    }
                }
            }
        }
        for (PlantOrganism org : plants) {
            distance = getDistanceTo(org);
            if (distance < this.eyeSight) {
                func = (0.3 * hungerCoefficient + 0.7 * (1.0 - nourishmentLevel)) * (1.0 - distance);
                //System.out.println("hungry: " + func);
                //System.out.println(distance);
                if (func > maxResult) {
                    maxResult = func;
                    //System.out.println("hunger coeff: " + func);
                    desired = org;//new Vector2D(or
                    // g.positionX, org.positionY);
                }
            }
        }
        return desired;
    }

    public void normalizeSpeed() {
        double absSpeed = Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
        if (absSpeed > maxSpeed) {
            velocityX = (velocityX / absSpeed) * maxSpeed;
            velocityY = (velocityY / absSpeed) * maxSpeed;
        }
    }

    // it is a factory method
    @Override
    public Organism createNewMember(Organism partner, int id) {
        HerbivoreOrganism newBorn = new HerbivoreOrganism(id + 1, (this.getSize() + partner.getSize()) / 2);
        HerbivoreOrganism partnerTmp = (HerbivoreOrganism) partner;
        newBorn.setAge(0);
        newBorn.setPositionX(this.positionX);
        newBorn.setPositionY(this.positionY);
        newBorn.setVelocityX(0.0);
        newBorn.setVelocityY(0.0);
        newBorn.setHungerCoefficient((this.hungerCoefficient + partnerTmp.hungerCoefficient) / 2.0 + (Math.random() - 0.5) / 20.0);
        newBorn.setMatingCoefficient((this.matingCoefficient + partnerTmp.matingCoefficient) / 2.0 + (Math.random() - 0.5) / 20.0);
        newBorn.setNourishmentLevel((this.nourishmentLevel + partnerTmp.nourishmentLevel) / 2.0);
        newBorn.setEyeSight(((this.eyeSight + partner.eyeSight) / 2.0) + (Math.random() - 0.5) / 1000.0);
        //System.out.println(newBorn.eyeSight);

        return newBorn;
    }


    public void setMatedRecently(boolean matedRecently) {
        this.matedRecently = matedRecently;
    }

    @Override
    public Organism update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants, int id) {

        Organism desiredOrg = getDesiredOrg(herbivores, plants);
        HerbivoreOrganism newBorn = null;

        if (desiredOrg != null) {
            if (getDistanceTo(desiredOrg) < interactionDistance && desiredOrg.getType().equals("herbivore")) {
                newBorn = (HerbivoreOrganism) createNewMember(desiredOrg, id);
                matedRecently = true;
                ((HerbivoreOrganism) desiredOrg).setMatedRecently(true);
                matingCount = 0;
                System.out.println("Mating stats:\n" + "1st: " + this.getNourishmentLevel()
                        + "; second: " + ((HerbivoreOrganism) desiredOrg).nourishmentLevel
                        + "; baby nourishment: " + newBorn.getNourishmentLevel() + " and its eyesight: "
                        + this.eyeSight + " mating: " + matingCoefficient + "; food desire: " + hungerCoefficient);
            } else if (getDistanceTo(desiredOrg) < interactionDistance && desiredOrg.getType().equals("plant")) {
                desiredOrg.kill();
                //System.out.println("killing a plant!");
                nourishmentLevel += ((desiredOrg.getSize() / 100.0) * 2.0) % 1.0;
                //System.out.println(nourishmentLevel);
            } else {
                velocityX = (desiredOrg.getPositionX() - this.getPositionX());//(Math.random() - 0.5) / 10000.0;
                velocityY = (desiredOrg.getPositionY() - this.getPositionY());
            }
        } else {
            velocityX += (Math.random() - 0.5) / 10000.0;
            velocityY += (Math.random() - 0.5) / 10000.0;
        }

        normalizeSpeed();

        if ((positionX <= 0.01 && velocityX < 0.0) || (positionX >= 0.99 && velocityX > 0.0)) {
            velocityX = 0.0;
        }
        if ((positionY <= 0.01 && velocityY < 0.0) || (positionY >= 0.99 && velocityY > 0.0)) {
            velocityY = 0.0;
        }

        positionX += velocityX;
        positionY += velocityY;

        nourishmentLevel -= this.size * (0.0014 / 60.0);
        if (nourishmentLevel <= 0.01) {
            this.kill();
            System.out.println("died of starvation");
        }

        return newBorn;
    }

    @Override
    public void incrementAge() {
        super.incrementAge();
        matingCount = (matingCount + 1);
        if (matingCount > 20)
            matingCount = 20;
        if (matingCount == 20)
            matedRecently = false;
    }

    @Override
    public String getType() {
        return "herbivore";
    }

    public double getNourishmentLevel() {
        return nourishmentLevel;
    }

    public void setHungerCoefficient(double hungerCoefficient) {
        this.hungerCoefficient = hungerCoefficient;
    }

    public void setMatingCoefficient(double matingCoefficient) {
        this.matingCoefficient = matingCoefficient;
    }

    public void setNourishmentLevel(double nourishmentLevel) {
        this.nourishmentLevel = nourishmentLevel;
    }
}
