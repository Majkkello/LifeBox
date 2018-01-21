package View.ViewFX;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by esromic on 2018-01-21.
 */
public class Herbivore extends GraphicalObject {
    public Herbivore(int id) {
        super(id, new Circle(12, 12, 15, Color.BROWN));
    }
}
