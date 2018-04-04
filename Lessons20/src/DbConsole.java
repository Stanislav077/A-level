import java.io.File;
import java.util.*;

/**
 * Created by Станислав on 04.04.2018.
 */
public class DbConsole {


    public static void main(String[] args) throws Exception {

        String csvFile = "F:\\java/TestTable.csv";
        Map<String, String> columnMapping = new HashMap<String, String>();

        Scanner scanner = new Scanner(new File(csvFile));
        while (scanner.hasNext()) {
            List<String> line = FileUtil.parseLine(scanner.nextLine());

            //System.out.println(line.toString());
            columnMapping.put(line.get(0),line.toString());

        }
        scanner.close();
        System.out.println(columnMapping);
        String sql = "CREATE TABLE REGISTRATION " +
                "(id INTEGER not NULL, " +
                " lname VARCHAR(255), " +
                " fname VARCHAR(255), " +
                " department VARCHAR(255), " +
                " position VARCHAR(255), " +
                " email VARCHAR(255), " +
                " mobile_phone VARCHAR(255), " +
                " home_phone VARCHAR(255), " +
                " логин VARCHAR(255), " +
                " пароль VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        SQLUtil.executeUpdateQuery(sql);

    }
}
