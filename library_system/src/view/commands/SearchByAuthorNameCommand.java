package view.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchByAuthorNameCommand implements Command{
    public String name = "저자 이름으로 검색";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List execute(Scanner in) {
        return new ArrayList();
    }
}
