package view.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReserveBookCommand implements Command{
    public String name = "도서 예약";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List execute(Scanner in) {
        // rent book logic
        System.out.println("Some reserve book logic");
        return new ArrayList();
    }
}
