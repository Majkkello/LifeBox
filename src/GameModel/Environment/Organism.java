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

    private boolean isAlive;
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

    public abstract Organism update(ArrayList<HerbivoreOrganism> herbivores, ArrayList<PlantOrganism> plants, int id);

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
        if (age > lifeExpectancy) {
            kill();
            if (this.getType().equals("herbivore"))
                System.out.println("Died of age.");
        }
    }

    public void kill() {
        isAlive = false;
    }

    public abstract String getType();

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setEyeSight(double eyeSight) {
        this.eyeSight = eyeSight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract Organism createNewMember(Organism partner, int id);

}
