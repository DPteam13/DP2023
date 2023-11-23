package view.commands;

public class RentBookCommand implements Command{
    public String name = "도서 대여";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some rent book logic");
    }
}
