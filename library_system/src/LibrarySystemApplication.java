import view.ConsoleView;
import view.MainView;

import java.util.Scanner;

public class LibrarySystemApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ConsoleView mainView = new MainView();
        mainView.run(in);
        in.close();
    }
}
