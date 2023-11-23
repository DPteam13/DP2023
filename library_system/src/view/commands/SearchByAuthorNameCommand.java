package view.commands;

public class SearchByAuthorNameCommand implements Command{
    public String name = "저자 이름으로 검색";

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
