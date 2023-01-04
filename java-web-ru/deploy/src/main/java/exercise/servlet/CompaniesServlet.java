package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companies = getCompanies();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String search = request.getParameter("search");
        PrintWriter out = response.getWriter();
        String result = null;

        if (search == null || request.getQueryString() == null) {
            for (String company: companies){
                out.println(company);
            }
        } else {
            for (String company : companies) {
                if (company.contains(search)) {
                    result += company;
                    out.println(company);
                }
               }
            if (result == null) {
                out.println("Companies not found");
            }
        }
        // END
    }
}
