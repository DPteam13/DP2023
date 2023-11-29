package common.domain;

public class Borrow {
    private static int idCounter = 1;
    private int id;
    private int userId;
    private int bookId;
    private String borrowDate;
    private String returnDate;
    private int isReturned;

    public Borrow(int userId, int bookId, String borrowDate, String returnDate, int isReturned) {
        id = idCounter++;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    public static void setIdCounter(int id){
        idCounter = id;
    }

    public static int getIdCounter(){
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getIsReturned() {
        return isReturned;
    }
}
