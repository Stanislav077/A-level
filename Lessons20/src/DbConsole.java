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

    }
}
