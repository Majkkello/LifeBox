package GameController.CommandLine;

import View.LifeBoxView;

import java.util.concurrent.CompletableFuture;

/**
 * Created by esromic on 2018-01-20.
 */
public class StartCommand implements Command {

    private LifeBoxView lifeBoxView;
    private CompletableFuture<Boolean> thread;

    public StartCommand(LifeBoxView lifeBoxApp, CompletableFuture<Boolean> completableFuture) {
        this.lifeBoxView = lifeBoxApp;
        this.thread = completableFuture;
    }

    @Override
    public void execute() {
        thread.supplyAsync(() -> lifeBoxView.startApp());
    }

    @Override
    public void undo() {

    }
}
