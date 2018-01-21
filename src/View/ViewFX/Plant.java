package View.ViewFX;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by esromic on 2018-01-21.
 */
public class Plant extends GraphicalObject {
    public Plant() {
        super(new Circle(5, 20, 20, Color.GREEN));
    }
}
