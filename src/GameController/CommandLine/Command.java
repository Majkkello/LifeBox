package GameController.CommandLine;

/**
 * Created by esromic on 2018-01-20.
 */
public interface Command {
    void execute() throws Exception;
    void undo();
}
