package GameModel.Environment;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by esromic on 2018-01-21.
 */
public class Organism {
    int id;

    double positionX;
    double positionY;

    double velocityX;
    double velocityY;

    int size;

    public Organism(double positionX, double positionY, double velocityX, double velocityY, int size) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.size = size;
    }

    public void update() {
        positionX += velocityX;
        positionY += velocityY;

        velocityX += (Math.random() - 0.5) / 100.0;
        velocityY += (Math.random() - 0.5) / 100.0;
    }

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
}
