package view;

import view.commands.*;

public class RentBookView extends ConsoleView{
    public RentBookView() {
        title = "도서 대출";
        options.add(new SearchByBookNameCommand());
        options.add(new SearchByAuthorNameCommand());
    }
}
