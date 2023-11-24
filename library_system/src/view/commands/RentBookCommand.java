package view.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentBookCommand implements Command{
    public String name = "도서 대여";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void execute(Scanner in) {
        // rent book logic
        System.out.println("Some rent book logic");

    }
}
