package view.commands;

import common.domain.Book;
import controller.SearchBookController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchByAuthorNameCommand implements Command{
    public String name = "저자 이름으로 검색";
    public SearchBookController searchBookController = SearchBookController.getInstance();

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println(name);
        System.out.print("저자 이름을 입력해 주세요 : ");
        String authorName = in.nextLine();
        List<Book> searchedBookList = searchBookController.searchByAuthor(authorName);
        System.out.println("Results");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |", "name", "author", "location", "isBorrowed" );
        System.out.println();
        for(int i = 0; i < searchedBookList.size(); i++){
            Book curBook = searchedBookList.get(i);
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |", curBook.getName(), curBook.getAuthor(), curBook.getLocation(), curBook.getIsBorrowed());
            System.out.println();
        }
        if (searchedBookList.size() == 0)
            System.out.println("결과 없음");

    }
}
