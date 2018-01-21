package GameController.CommandLine;

import View.LifeBoxView;
import java.util.concurrent.CompletableFuture;

/**
 * Created by esromic on 2018-01-20.
 */
public class ExitCommand implements Command {
    CompletableFuture<Boolean> stopThread;
    LifeBoxView lifeBoxView;

    public ExitCommand(LifeBoxView lifeBoxView, CompletableFuture<Boolean> completableFuture) {
        this.lifeBoxView = lifeBoxView;
        stopThread = completableFuture;
    }

    @Override
    public void execute() throws Exception {
        lifeBoxView.closeApp();
        //stopThread.thenApply(a -> lifeBoxView.closeApp());
    }

    @Override
    public void undo() {

    }
}
