package View.ViewFX;

import View.LifeBoxView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by esromic on 2018-01-20.
 */
public class LifeBoxApp extends Application implements LifeBoxView {
    private Pane root;
    private static Stage stage;

    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(800, 800);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    @Override
    public Boolean startApp() {
        Application.launch();
        return true;
    }

    @Override
    public Boolean closeApp() {
        Platform.exit();
        //this.stop();
        return true;
    }

    @Override
    public void stop() {
        System.out.println("Quiting...");
    }

    @Override
    public void start(Stage stage) {
        LifeBoxApp.stage = stage;
        LifeBoxApp.stage.setTitle("Life Box");
        LifeBoxApp.stage.setScene(new Scene(createContent()));
        Platform.setImplicitExit(false);
        LifeBoxApp.stage.show();
    }

    public void onUpdate() {
        // get status
        // draw all objects
        if (Math.random() < 0.005) {
            addGraphicalObject(new Herbivore(), Math.random() * root.getPrefWidth(), Math.random() * root.getPrefHeight());
        }
    }

    public void addGraphicalObject(GraphicalObject obj, double x, double y) {
        obj.getView().setTranslateX(x);
        obj.getView().setTranslateY(y);
        root.getChildren().add(obj.getView());
    }

}
