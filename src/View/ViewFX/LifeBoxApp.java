package View.ViewFX;

import GameModel.Environment.Environment;
import GameModel.Environment.Organism;
import View.LifeBoxView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esromic on 2018-01-20.
 */
public class LifeBoxApp extends Application implements LifeBoxView {
    private Environment environment = new Environment(5, 10);
    private List<GraphicalObject> plants = new ArrayList<>();
    private List<GraphicalObject> herbivores = new ArrayList<>();
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
        addAllGraphicalObjects();
        LifeBoxApp.stage.show();
    }

    public void onUpdate() {
        // get status
        // draw all objects

        if (Math.random() < 0.005) {
            addGraphicalObject(new Plant(), Math.random() * root.getPrefWidth(), Math.random() * root.getPrefHeight());
        }
    }

    public void addGraphicalObject(GraphicalObject obj, double x, double y) {
        obj.getView().setTranslateX(x);
        obj.getView().setTranslateY(y);
        root.getChildren().add(obj.getView());
    }

    public void addAllGraphicalObjects() {
        for (Organism org : environment.getPlants()) {
            plants.add(new Plant());
            addGraphicalObject(plants.get(plants.size() - 1),
                    org.getPositionX() * root.getPrefWidth(),
                    org.getPositionY() * root.getPrefHeight());
        }
        for (Organism org : environment.getHerbivores()) {
            herbivores.add(new Herbivore());
            addGraphicalObject(herbivores.get(herbivores.size() - 1),
                    org.getPositionX() * root.getPrefWidth(),
                    org.getPositionY() * root.getPrefHeight());
        }
    }

}
