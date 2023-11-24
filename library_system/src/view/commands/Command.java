package view.commands;

import java.util.List;
import java.util.Scanner;

public interface Command {
    List execute(Scanner in);
    String getName();
}
