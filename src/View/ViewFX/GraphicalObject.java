package View.ViewFX;

import com.sun.javafx.geom.Point2D;
import javafx.scene.Node;

/**
 * Created by esromic on 2018-01-21.
 */
public class GraphicalObject {
    private int id;
    private Node view;
    private Point2D velocity = new Point2D(0, 0);
    private int size;

    private boolean alive = true;

    public GraphicalObject(int id, int size, Node view) {
        this.id = id;
        this.size = size;
        this.view = view;
    }

    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.x);
        view.setTranslateY(view.getTranslateY() + velocity.y);
    }

    public void update(double xCoord, double yCoord) {
        view.setTranslateX(xCoord);
        view.setTranslateY(yCoord);
    }

    public int getId() {
        return id;
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public Node getView() {
        return view;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getRotate() {
        return view.getRotate();
    }

    public int getSize() {
        return size;
    }
}
