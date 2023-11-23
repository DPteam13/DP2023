package view;

import view.commands.Command;
import view.commands.RentBookCommand;
import view.commands.ReturnBookCommand;
import view.commands.SearchBookCommand;

public class MainView extends ConsoleView{
    public MainView() {
        title = "Main";
        options.add(new RentBookCommand());
        options.add(new ReturnBookCommand());
        options.add(new SearchBookCommand());
    }
}
