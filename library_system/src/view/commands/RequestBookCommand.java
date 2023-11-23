package src.view.commands;

public class RequestBookCommand implements Command{
    public String name = "도서 신청";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some request book logic");
    }
}
