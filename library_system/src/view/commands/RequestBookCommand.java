package view.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestBookCommand implements Command{
    public String name = "도서 신청";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List execute(Scanner in) {
        // rent book logic
        System.out.println("Some request book logic");
        return new ArrayList();
    }
}
