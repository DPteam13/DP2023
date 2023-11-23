package view.commands;

public class ReserveBookCommand implements Command{
    public String name = "도서 예약";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute() {
        // rent book logic
        System.out.println("Some reserve book logic");
    }
}
