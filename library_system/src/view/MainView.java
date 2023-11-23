package src.view;

import src.view.commands.Command;
import src.view.commands.RentBookCommand;
import src.view.commands.ReturnBookCommand;
import src.view.commands.SearchBookCommand;

public class MainView extends ConsoleView{
    public MainView() {
        title = "Main";
        options.add(new RentBookCommand());
        options.add(new ReturnBookCommand());
        options.add(new SearchBookCommand());
    }
}
