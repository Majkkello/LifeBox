package GameModel.Environment;

import com.sun.prism.image.Coords;

import java.util.ArrayList;

/**
 * Created by esromic on 2018-01-21.
 */
public abstract class Organism {
    int lifeExpectancy;
    int id;

    double positionX;
    double positionY;

    double velocityX;
    double velocityY;

    double eyeSight;
    int age;

    boolean isAlive;
    int size;

    public Organism(int id, double positionX, double positionY, double velocityX, double velocityY, int size) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.size = size;
        this.age = 0;
        this.isAlive = true;
    }

    public abstract void update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants);



    //public abstract void react();

    public int getId() {
        return id;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public int getSize() {
        return size;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getDistanceTo(Organism org) {
        return Math.sqrt(Math.pow(org.getPositionX() - this.getPositionX(), 2) + Math.pow(org.getPositionY() - this.getPositionY(), 2));
    }

    public void incrementAge() {
        this.age++;
        updateBeingDeadOfAge();
    }

    public void updateBeingDeadOfAge() {
        if (age > lifeExpectancy)
            kill();
    }

    public void kill() {
        isAlive = false;
    }
}
