package src.view;

import src.view.commands.Command;
import src.view.commands.RentBookCommand;
import src.view.commands.ReturnBookCommand;

public class MainView extends ConsoleView{
    public MainView() {
        this.title = "Main";
        Command rentBookCommand = new RentBookCommand();
        Command returnBookCommand = new ReturnBookCommand();
        this.options.add(rentBookCommand);
        this.options.add(returnBookCommand);
    }
}
