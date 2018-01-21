package View.ViewFX;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by esromic on 2018-01-21.
 */
public class Herbivore extends GraphicalObject {
    public Herbivore(int id, int size) {
        super(id, size, new Circle(12, 12, size, Color.BROWN));
    }
}
