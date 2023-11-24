package view.commands;

import java.util.List;
import java.util.Scanner;

public interface Command {
    void execute(Scanner in);
    String getName();
}
