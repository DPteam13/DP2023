package common.domain;

public class Book {

    public Book(String bookId, String name, String location, String isbn, String publisher, String author, String isBorrowed){
        this.bookId = bookId;
        this.name = name;
        this.location = location;
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
        this.isBorrowed = isBorrowed;
    };
    public Book(){};
    private String bookId;
    private String name;
    private String location;
    private String isbn;
    private String publisher;

    private String author;
    private String isBorrowed;


    ////////////////////////////////////////////////////
    // Getters and setters

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(String isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
