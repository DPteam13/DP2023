import view.View;
import view.MainMenuView;

import java.io.IOException;
import java.util.Scanner;

public class LibrarySystemApplication {
    public static void main(String[] args) throws IOException {
        LoadData dataloader = new LoadData();
        dataloader.LoadData_CSV();
        Scanner in = new Scanner(System.in);
        View mainView = new MainMenuView();
        mainView.run(in);
        in.close();

    }
}
