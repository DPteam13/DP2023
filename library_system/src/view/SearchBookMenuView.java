package view;

import view.commands.*;

import java.util.ArrayList;

public class SearchBookMenuView extends View {
    public SearchBookMenuView() {
        title = "도서 검색";
        options = new ArrayList<>();
        options.add(new SearchByBookNameCommand());
        options.add(new SearchByAuthorNameCommand());
    }
}
