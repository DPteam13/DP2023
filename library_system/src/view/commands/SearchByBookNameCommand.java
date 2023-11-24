package view.commands;

import common.domain.Book;
import controller.SearchBookController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchByBookNameCommand implements Command{
    public String name = "책 제목으로 검색";
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List execute(Scanner in) {
        SearchBookController searchBookController = new SearchBookController();
        System.out.print("책 제목을 입력해 주세요 : ");
        String bookTitle = in.nextLine();
        List<Book> searchedBookList = searchBookController.searchByBookName(bookTitle);
        return searchedBookList;
    }
}
