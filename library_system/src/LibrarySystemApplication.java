import view.View;
import view.MainMenuView;

import java.util.Scanner;

public class LibrarySystemApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        View mainView = new MainMenuView();
        mainView.run(in);
        in.close();
    }
}
