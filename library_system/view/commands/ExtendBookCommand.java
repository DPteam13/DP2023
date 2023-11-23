package view.commands;

public class ExtendBookCommand implements Command{
    public String name = "도서 연장";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some extend book logic");
    }
}
