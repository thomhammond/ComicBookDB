import com.amazonaws.services.dynamodbv2.document.Table;

public class App {
    public static void main(String[] args) {
        ComicBookTableHelper comicBookTableHelper = new ComicBookTableHelper();
        Table table = comicBookTableHelper.createTable();
        if (table != null) {
            System.out.println("Deleting ComicBook Table and ending session.");
            comicBookTableHelper.deleteTable(table);
        }
    }
}
