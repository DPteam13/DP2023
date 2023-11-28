package view;

import view.commands.BorrowBookCommand;
import view.commands.ReturnBookCommand;
import view.commands.SearchBookCommand;

import java.util.ArrayList;

public class MainMenuView extends View {
    public MainMenuView() {
        title = "Main";
        options = new ArrayList<>();
        options.add(new BorrowBookCommand());
        options.add(new ReturnBookCommand());
        options.add(new SearchBookCommand());
    }
}
