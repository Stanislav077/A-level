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
             Statement statement = connection.createStatement();
            ) {
//            while (resultSet.next()) {
//                String first_name = resultSet.getNString(1);
//                String last_name = resultSet.getNString(2);
//              Date hire_date = resultSet.getDate("hire_date");
//               employees.add(new Employee(first_name,last_name,hire_date));
//            }
//            for(int i=0;i<200;i++){
//                System.out.println(employees.get(i));
//            }
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }



    }

}
