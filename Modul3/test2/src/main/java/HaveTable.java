import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Станислав on 04.05.2018.
 */
@WebServlet(name = "HaveTable",
        urlPatterns = "/havetable"
)
public class HaveTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String query = "SELECT * FROM tables t LEFT JOIN tables_value v on(t.id_table_name = v.table_name_id)";

        Map<String, String> table = new HashMap<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "root", "");

             PreparedStatement selectStatement = connection.prepareStatement(query);
             ResultSet resultSet = selectStatement.executeQuery(query)

        ) {
            int i =0;
            while ( resultSet.next() ) {
                // Read the next item
              //  res_id =  resultSet.getString("id_table_name");
                table.put( resultSet.getString("table_name")+"_"+resultSet.getString("tabels_id"),
                        resultSet.getString("row_value"));



               // table.put("id_table_name_" + i, resultSet.getString("id_table_name"));
                //table.put("table_name_" + i, resultSet.getString("table_name"));
                i++;
            }


        } catch (SQLException e) {
            //  e.printStackTrace();
        }
        String json = new Gson().toJson(table);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

            out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
