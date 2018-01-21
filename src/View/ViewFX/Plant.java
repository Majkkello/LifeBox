package View.ViewFX;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by esromic on 2018-01-21.
 */
public class Plant extends GraphicalObject {
    public Plant(int id, int size) {
        super(id, size, new Circle(10, 10, size, Color.GREEN));
    }
}
