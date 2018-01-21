package GameController;

import GameController.CommandLine.CommandListener;
import View.LifeBoxApp;
import javafx.application.Application;

/**
 * Created by esromic on 2018-01-20.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        CommandListener commandListener = new CommandListener();
        commandListener.listenCommands();

    }


}
