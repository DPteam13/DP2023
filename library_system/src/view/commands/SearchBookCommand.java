package view.commands;

import view.RentBookView;

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
    public List execute(Scanner in) {
        new RentBookView().run(in);
        return new ArrayList();
    }
}
