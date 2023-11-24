package view.commands;

import view.SearchBookMenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBookCommand implements Command{
    public String name = "도서 검색";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        new SearchBookMenuView().run(in);
    }
}
