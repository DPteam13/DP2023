package view;

import view.commands.RentBookCommand;
import view.commands.ReturnBookCommand;
import view.commands.SearchBookCommand;

import java.util.ArrayList;

public class MainView extends View {
    public MainView() {
        title = "Main";
        options = new ArrayList<>();
        options.add(new RentBookCommand());
        options.add(new ReturnBookCommand());
        options.add(new SearchBookCommand());
    }
}
