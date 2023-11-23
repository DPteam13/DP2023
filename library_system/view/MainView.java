package view;

import view.commands.Command;
import view.commands.RentBookCommand;
import view.commands.ReturnBookCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView extends ConsoleView{
    public MainView() {
        this.title = "Main";
        Command rentBookCommand = new RentBookCommand();
        Command returnBookCommand = new ReturnBookCommand();
        this.options.add(rentBookCommand);
        this.options.add(returnBookCommand);
    }
}
