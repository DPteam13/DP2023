package common.domain;

public class Book {

    public Book(String name, String Isbn, int classificationCode, int publisherId, int authorId, int isBorrowed){
        this.name = name;
        this.Isbn = Isbn;
        this.classificationCode = classificationCode;
        this.publisherId = publisherId;
        this.authorId = authorId;
        this.isBorrowed = isBorrowed;
    };
    public Book(){};
    private int bookId;

    private String name;

    private String Isbn;

    private int classificationCode;

    private int publisherId;

    private int authorId;

    private int isBorrowed;

    ////////////////////////////////////////////////////
    // Getters and setters
    public int getBookId(){
        return bookId;
    }
    public void setBookId(int bookId){
        this.bookId = bookId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getIsbn(){
        return Isbn;
    }
    public void setIsbn(String Isbn){
        this.Isbn = Isbn;
    }
    public int getClassificationCode(){
        return classificationCode;
    }
    public void setClassificationCode(int classificationCode){
        this.classificationCode = classificationCode;
    }
    public int getPublisherId(){
        return publisherId;
    }
    public void setPublisherId(int publisherId){
        this.publisherId = publisherId;
    }
    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int authorId){
        this.authorId = authorId;
    }
    public int getIsBorrowed(){
        return isBorrowed;
    }
    public void setIsBorrowed(int isBorrowed){
        this.isBorrowed = isBorrowed;
    }
}
