package view.commands;

import controller.ReturnController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnBookCommand implements Command{
    public String name = "도서 반납";
    public ReturnController returnController = ReturnController.getInstance();
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        while(true) {
            System.out.print("반납 할 책 ID를 입력해 주세요(종료:0):");
            int bookId = in.nextInt();
            in.nextLine();
            if(bookId == 0)
                break;
            int result = returnController.returnBookByBookId(bookId);
            if(result == 0)
                System.out.println("반납 할 수 없습니다");
            else
                System.out.println("반납 완료");
        }

    }
}
