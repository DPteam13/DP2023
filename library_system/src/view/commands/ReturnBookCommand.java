package view.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnBookCommand implements Command{
    public String name = "도서 반납";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        // rent book logic
        System.out.println("Some return book logic");
    }
}
