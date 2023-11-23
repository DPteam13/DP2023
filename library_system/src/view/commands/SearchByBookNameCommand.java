package view.commands;

public class SearchByBookNameCommand implements Command{
    public String name = "책 이름으로 검색";

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
