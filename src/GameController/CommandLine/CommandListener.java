package GameController.CommandLine;

import View.LifeBoxView;
import View.ViewFX.LifeBoxApp;
import com.sun.org.apache.xpath.internal.SourceTree;

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
        System.out.println("Hi!\n" +
                "Welcome to Life Box - your sandbox of life!\n" +
                "List of commands You can use:\n" +
                "start - open a box full of life\n" +
                "stop - close the box\n" +
                "exit - exit the program");
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
            command = new CloseCommand(lifeBoxView, graphicsThread);
        } else if (crrCommand.equals("exit")){
            command = new ExitCommand(lifeBoxView, graphicsThread);
        }
        else{
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
