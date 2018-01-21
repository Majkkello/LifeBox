package GameController.CommandLine;

/**
 * Created by esromic on 2018-01-20.
 */
public class WrongCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Command not found!");
    }

    @Override
    public void undo() {

    }
}
