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
        String[] values = request.getParameterValues("row");

        Map<String, String> table = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            table.put("Row_" + i, values[i]);
        }

        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println("ID =  " + entry.getKey() + " День недели = " + entry.getValue());
        }

        String queryas = "SELECT * FROM `tabels` WHERE 1";

        String query = "CREATE TABLE tabels\n" +
                "(\n" +
                "tabels_id int,\n" +
                "row_name varchar(255),\n" +
                "row_value varchar(255),\n" +
                "PRIMARY KEY (tabels_id)" +
                ");";

        String query2 = "ALTER TABLE  `tabels` MODIFY  `tabels_id` INT( 11 ) NOT NULL AUTO_INCREMENT\n";
        String query3 = "INSERT INTO tabels SET row_name=?,row_value=?";


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(queryas);
             ResultSet resultSet = preparedStatement.executeQuery(queryas)
        ) {
            for (Map.Entry<String, String> entry : table.entrySet()) {

                updateTable(query3,entry.getKey(),entry.getValue());
            }


        } catch (SQLException e) {
            createTable(query);
            alterTable(query2);
            for (Map.Entry<String, String> entry : table.entrySet()) {

                updateTable(query3,entry.getKey(),entry.getValue());
            }
        }


        String json = new Gson().toJson(table);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.write(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateTable(String query3, String row_name, String row_value) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query3);

        ) {
           //
            preparedStatement.setString(1,row_name);
            preparedStatement.setString(2,row_value);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void alterTable(String query2) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query2);

        ) {
            preparedStatement.executeUpdate(query2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {
            preparedStatement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
