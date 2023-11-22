package service;

import model.domain.Book.Book;

public interface BookService {

    // 해당 interface를 PaperBookService, EBookService로 Strategy패턴 적용.
    // 다양한 컨테츠에 대한 Service를 각각의 클래스에 대해 생성할 수 있으며 Controller단에서 필요한 Strategy를 적절하게 선태한다.

    // 등록

    // 대여
    public void borrow(Book book);

    // 예약

    // 반납

}
