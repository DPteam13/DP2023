package view.commands;

import common.domain.Book;
import controller.SearchBookController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchByBookNameCommand implements Command{
    public String name = "책 제목으로 검색";
    public SearchBookController searchBookController = SearchBookController.getInstance();

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        System.out.print("책 제목을 입력해 주세요 : ");
        String bookTitle = in.nextLine();
        List<Book> searchedBookList = searchBookController.searchByBookName(bookTitle);
        System.out.println("Results");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |", "name", "author","location" ,"isBorrowed");
        System.out.println();
        for(int i = 0; i < searchedBookList.size(); i++){
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |", searchedBookList.get(i).getName(), searchedBookList.get(i).getAuthor(),searchedBookList.get(i).getLocation(), searchedBookList.get(i).getIsBorrowed());
            System.out.println();
        }
        if(searchedBookList.size() == 0){
            System.out.println("결과 없음");
        }
    }
}
