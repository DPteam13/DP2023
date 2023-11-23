package src.view.commands;

public class SearchBookCommand implements Command{
    public String name = "도서 검색";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some search book logic");
    }
}
