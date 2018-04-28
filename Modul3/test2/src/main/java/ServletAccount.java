import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Станислав on 25.04.2018.
 */
@WebServlet(name = "Servlet",
        urlPatterns = "/account"
)
public class ServletAccount extends HttpServlet {
    private static String name="";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // name=request.getParameter("name");

      //  RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
    //    requestDispatcher.forward(request, response);

     //   JsonObject jsonObject = new JsonObject();

        response.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
        response.setCharacterEncoding("utf-8");//Кодировка отправляемых данных



        try (PrintWriter out = response.getWriter()) {
            JsonObject jsonEnt = new JsonObject();

           // JsonElement rows =  jsonEnt.getAsJsonArray();

            //out.print(jsonEnt.toString());
            out.print(jsonEnt.getAsJsonArray());
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
        requestDispatcher.forward(request, response);
    }
}
