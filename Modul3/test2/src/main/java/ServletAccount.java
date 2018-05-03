import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Data;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.*;
import java.util.*;

/**
 * Created by Станислав on 25.04.2018.
 */
@WebServlet(name = "Servlet",
        urlPatterns = "/account"
)
public class ServletAccount extends HttpServlet {
    //private static String name="";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String tableName = request.getParameter("table_name");
        String[] values = request.getParameterValues("row");

        Map<String, String> table = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            table.put("Row_" + i, values[i]);
        }

        String queryas = "SELECT * FROM tables WHERE table_name='"+tableName+"'";


        String query = "INSERT INTO tables_value SET row_name=?,row_value=?,table_name_id=?";
        String res_id ="";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(queryas);
             ResultSet resultSet = preparedStatement.executeQuery(queryas)
        ) {


            while ( resultSet.next() ) {
                // Read the next item
                res_id =  resultSet.getString("id_table_name");


            }


            if(res_id==""){
                createTableName(tableName);

                  String new_id = resIdTableName(tableName);

                for (Map.Entry<String, String> entry : table.entrySet()) {

                    updateTable(query,entry.getKey(),entry.getValue(),new_id);
                }


            }else{
                deleteValue(res_id);
            for (Map.Entry<String, String> entry : table.entrySet()) {

                updateTable(query,entry.getKey(),entry.getValue(),res_id);
            }
            }



        } catch (SQLException e) {
            createTableName(tableName);

            //for (Map.Entry<String, String> entry : table.entrySet()) {

              //  updateTable(query,entry.getKey(),entry.getValue());
            //}
        }


        String json = new Gson().toJson(table);
        String json2 = new Gson().toJson(tableName);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

    //    out.write(json+' '+json2);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateTable(String query, String row_name, String row_value, String res_id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {
           //
            preparedStatement.setString(1,row_name);
            preparedStatement.setString(2,row_value);
            preparedStatement.setString(3,res_id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void createTableName(String table){



String insert_table = "INSERT INTO tables set table_name='"+table+"'";


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");

             PreparedStatement insertStatement = connection.prepareStatement(insert_table);


        ) {

            insertStatement.executeUpdate(insert_table);

        } catch (SQLException e) {
          //  e.printStackTrace();
        }

    }

    private String resIdTableName(String table){



        String select_table = "SELECT * FROM tables WHERE table_name='"+table+"'";
String res_id="";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");

             PreparedStatement selectStatement = connection.prepareStatement(select_table);
             ResultSet resultSet = selectStatement.executeQuery(select_table)

        ) {
            while ( resultSet.next() ) {
                // Read the next item
               res_id =  resultSet.getString("id_table_name");


            }


        } catch (SQLException e) {
            //  e.printStackTrace();
        }
return res_id;
    }

    private void deleteValue(String res_id){



        String delete_table = "DELETE FROM `tables_value` WHERE `table_name_id`='"+res_id+"'";


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");

             PreparedStatement insertStatement = connection.prepareStatement(delete_table);


        ) {

            insertStatement.executeUpdate(delete_table);

        } catch (SQLException e) {
            //  e.printStackTrace();
        }

    }
}
