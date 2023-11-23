package src.view.commands;

public class ReturnBookCommand implements Command{
    public String name = "도서 반납";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some return book logic");
    }
}
