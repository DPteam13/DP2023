import context.DBConnectionManager;
import view.View;
import view.MainMenuView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySystemApplication {
    public static void main(String[] args) throws IOException, SQLException {
//        LoadData dataloader = new LoadData();
//        dataloader.LoadData_CSV();

        while(true) {
            Scanner in = new Scanner(System.in);
            View mainView = new MainMenuView();
            mainView.run(in);
            in.close();
        }

    }
}
