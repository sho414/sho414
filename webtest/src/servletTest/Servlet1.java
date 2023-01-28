package servletTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body>");
        out.println("<p>Simple Application</p>");
        out.println("<p>Hello World!</p>");
        out.println("<p>Hello World!</p>");
        out.println("</body></html>");

        try {

	        DatabaseSrTest oradb = new DatabaseSrTest();
	        ArrayList<String> result = oradb.select("select * from test01","col02");

			//結果をブラウザへ
			StringBuilder sb = new StringBuilder();

			for(int i=0;i<result.size();i++) {
				sb.append("<html><body>").append(result.get(i)).append("</br></body></html>");
			}

			PrintWriter pw = response.getWriter();
			pw.write(sb.toString());
			pw.flush();
			pw.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

    }
}