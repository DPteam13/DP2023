package view;

import view.commands.*;

import java.util.ArrayList;

public class RentBookView extends View {
    public RentBookView() {
        title = "도서 대출";
        options = new ArrayList<>();
        results = new ArrayList<>();
        options.add(new SearchByBookNameCommand());
        options.add(new SearchByAuthorNameCommand());
    }
}
