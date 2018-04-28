import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Станислав on 21.04.2018.
 */



@WebServlet(
        name = "MyOwnServlet",
        description = "This is my first annotated servlet",
        urlPatterns = "/hello"
)

public class TestServlet extends HttpServlet {

public static final String COUNT = "count";
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

      String name =  httpServletRequest.getParameter("name");

        Cookie[] cookies = httpServletRequest.getCookies();
int counter =0;
        for (Cookie cookie: cookies ) {
            if(cookie.getName().equals(COUNT)){
               counter = Integer.valueOf(cookie.getValue());

            }
        }

      httpServletResponse.addCookie(new Cookie(COUNT, String.valueOf(++counter)));


        PrintWriter writer = httpServletResponse.getWriter();
        writer.println("<html><header></header><body>Hello, "+ name + "</body></html>");
        writer.flush();
        writer.close();
    }




}


