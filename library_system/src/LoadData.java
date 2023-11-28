import com.holub.database.CSVImporter;
import com.holub.database.Table;
import com.holub.database.XMLImporter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class LoadData {

    void LoadData_CSV() throws IOException {
        try {
            Reader reader = new FileReader("C:\\Users\\CAU\\Documents\\GitHub\\DP2023\\Holup\\Dbase\\Book.csv");
            Table.Importer importer = new CSVImporter(reader);

            importer.startTable();

            Iterator it = importer.loadColumnNames();

            while (it.hasNext()){
                String col = (String) it.next();
                System.out.printf("%50s", col);
            }

            while(true) {
                Iterator it2 = importer.loadRow();
                if(it2 == null){
                    break;
                }
                while (it2.hasNext()){
                    String col = (String) it2.next();
                    if(col.length() > 50 ) col = col.substring(0, 47) + "...";
                    System.out.printf("%-60s", col);
                }
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
