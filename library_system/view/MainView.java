package view;

import view.commands.Command;
import view.commands.RentBookCommand;
import view.commands.ReturnBookCommand;
import view.commands.SearchBookCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView extends ConsoleView{
    public MainView() {
        this.title = "Main";
        this.options.add(new RentBookCommand());
        this.options.add(new ReturnBookCommand());
        this.options.add(new SearchBookCommand());
    }
}
