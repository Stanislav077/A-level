import java.sql.*;
import java.util.Map;

/**
 * Created by Станислав on 04.04.2018.
 */
public class SQLUtil {



    public static String createTableQuery(Map<String, String> mapTable){

        return "";
    }
    public static void fillDataQuery(){

    }
    public static void addKeys(){

    }
    public  static void executeSelectQuery(String select)
    {






    }
    public  static void executeUpdateQuery(String sql)
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             Statement statement =  connection.createStatement()
        )
        {


            //executeUpdate(sql);
            statement.executeUpdate(sql);



        }catch (SQLException e){
            e.printStackTrace();
        }



    }

}
