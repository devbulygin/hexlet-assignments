package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Type;
import java.util.*;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.User;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/users.json");
        List<User> userList = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
        return userList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();
        List<User> users = getUsers();

        String head = """
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application</title>
                        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                              rel=\"stylesheet\"
                              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                              crossorigin=\"anonymous\">
                    </head>""";
        String body = """
                <body>
                <table>
                """;

        for (User user : users) {
            String id = user.getId();
            String fullName = user.getFirstName() + " " + user.getLastName();
            body += "<tr><td>" + id + "</td><td><a href=/users/" + id + ">" + fullName + "</a></td></tr>" ;
        }
        body += """
                </table>
                </body>
                </html>
                """;
        printWriter.write(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                          HttpServletResponse response,
                          String id)
            throws IOException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();
        List<User> users = getUsers();
        boolean found = false;

        List<String> userId = new ArrayList<>();

        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);

        if (user != null) {
            String body = """
                    <!DOCTYPE html>
                    <html lang=\"ru\">
                        <head>
                            <meta charset=\"UTF-8\">
                            <title>Example application</title>
                            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                                  rel=\"stylesheet\"
                                  integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                                  crossorigin=\"anonymous\">
                        </head>
                    <body>
                    <table>
                    """;
            body += "<tr>"
                    + "<td>" + user.getFirstName() + "</td>"
                    + "<td>" + user.getLastName() + "</td>"
                    + "<td>" + id + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "</tr>" ;
            body += """
                    </table>
                    </body>
                    </html>
                    """;
            printWriter.write(body);
        } else {
            response.sendError(404);
    }
    // END
}
}

