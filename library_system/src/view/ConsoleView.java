package src.view;

import src.view.commands.Command;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleView{
    String logo =
            ".____      .___  __________  __________     _____    __________  _____.___.    _________ _____.___.   _________ ___________ ___________    _____   \n" +
                    "|    |     |   | \\______   \\ \\______   \\   /  _  \\   \\______   \\ \\__  |   |   /   _____/ \\__  |   |  /   _____/ \\__    ___/ \\_   _____/   /     \\  \n" +
                    "|    |     |   |  |    |  _/  |       _/  /  /_\\  \\   |       _/  /   |   |   \\_____  \\   /   |   |  \\_____  \\    |    |     |    __)_   /  \\ /  \\ \n" +
                    "|    |___  |   |  |    |   \\  |    |   \\ /    |    \\  |    |   \\  \\____   |   /        \\  \\____   |  /        \\   |    |     |        \\ /    Y    \\\n" +
                    "|_______ \\ |___|  |______  /  |____|_  / \\____|__  /  |____|_  /  / ______|  /_______  /  / ______| /_______  /   |____|    /_______  / \\____|__  /\n" +
                    "        \\/               \\/          \\/          \\/          \\/   \\/                 \\/   \\/                \\/                      \\/          \\/ ";
    public String title;
    public List<Command> options = new ArrayList<>();

    public void display(){
        System.out.println(logo);
        dash(90);
        newLine(1);
        printTitle();
        newLine(1);
        dash(90);
        newLine(1);
        for(int idx = 0; idx < options.size(); idx++){
            System.out.println((idx+1) + ". " + options.get(idx).getName());
        }
        dash(90);
        newLine(1);
        System.out.print("메뉴를 선택해 주세요 : ");
    }
    public void run(Scanner in) {
        while(true) {
            display();
            int selection = getInput(in);
            select(selection-1);
        }
    }
    public void select(int idx) {
        if(idx == -1)
            return;
        options.get(idx).execute();
    }
    public void printTitle(){
        System.out.print(title);
    }
    public void newLine(int num){
        for(int i = 0; i < num; i++)
            System.out.println();
    }
    public void dash(int num){
        for(int i = 0; i < num; i++)
            System.out.print("-");
    }
    public int getInput(Scanner in){
        try {
            int selection = in.nextInt();
            if(!isValidChoice(selection))
                throw new InputMismatchException();
            in.nextLine();
            return selection;
        } catch (InputMismatchException e) {
            in.nextLine();
            System.out.println("유효하지 않은 선택 입니다. 메뉴를 다시 선택 해주세요.");
            return 0;
        } catch (Exception e){
            in.nextLine();
            e.printStackTrace();
            System.out.println("Unknown Error");
            return 0;
        }
    }
    public boolean isValidChoice(int selection){
        if(1 <= selection && selection <= options.size())
            return true;
        return false;
    }
}
