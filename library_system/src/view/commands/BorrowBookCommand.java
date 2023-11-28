package view.commands;

import controller.BorrowController;

import java.util.Scanner;

public class BorrowBookCommand implements Command{
    public String name = "도서 대여";
    BorrowController borrowController = BorrowController.getInstance();
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        System.out.print("유저 아이디를 입력해 주세요: ");
        int userId = in.nextInt();
        in.nextLine();
        while(true){
            System.out.print("대여할 책 ID를 입력해 주세요 (종료 : 0): ");
            int bookId = in.nextInt();
            in.nextLine();
            if(bookId == 0)
                break;

            int result = borrowController.borrow(bookId, userId);
            if(result == 0)
                System.out.println("대여가 불가능 합니다.");
            else
                System.out.println("대여 완료");
        }
    }
}
