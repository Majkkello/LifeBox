package GameController.CommandLine;


import View.LifeBoxApp;
import View.LifeBoxView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * Created by esromic on 2018-01-20.
 */
public class CommandListener {
    CompletableFuture<Boolean> graphicsThread;

    private LifeBoxView lifeBoxView = new LifeBoxApp();
    private int crrCommandzIndex = 0;
    private List<String> commands = new LinkedList<>();

    public CommandListener() {
    }

    private void getCommand() {
        Scanner scanner = new Scanner(System.in);
        commands.add(scanner.nextLine());
    }

    private void executeFirst() throws Exception {
        String crrCommand = commands.get(crrCommandzIndex);
        Command command;
        if (crrCommand.equals("start")) {
            command = new StartCommand(lifeBoxView, graphicsThread);
        } else if (crrCommand.equals("stop")) {
            command = new ExitCommand(lifeBoxView, graphicsThread);
        } else {
            command = new WrongCommand();
        }
        command.execute();
    }

    public void listenCommands() throws Exception {
        while (true) {
            getCommand();
            executeFirst();
            crrCommandzIndex++;
            //System.exit(0);
        }
    }

}
