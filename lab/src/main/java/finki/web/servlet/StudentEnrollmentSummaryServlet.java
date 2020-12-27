package finki.web.servlet;

import finki.model.Student;
import finki.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "student-enrollment-summary", urlPatterns ="/studentEnrollment")
public class StudentEnrollmentSummaryServlet extends HttpServlet {
    private final StudentService studentService;

    public StudentEnrollmentSummaryServlet(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.listAll();
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h2>Info about our request</h2>");
        writer.format("IP Address:%s, Browser: %s",ipAddress,clientAgent);
        writer.println("<h2>Categories</h2>");
        writer.println("<ul>");
        studentList.forEach(r->
                writer.format("<li>%s (%s)</li>",r.getName(),r.getSurname()));
        writer.println("</ul>");

        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h3>Add New Category</h3>");
        writer.println("<form method='post' action='/servlet/category'>" +
                "<label for='name'>Name:</label><input id='name' type='text' name='name'/>"+
                "<label for='desc'>Description:</label><input id='desc' type='text' name='description'/>"+
                "<input type='submit' value='Submit'/>"+
                "</form>");
        writer.println("</body>");
        writer.println("<html>");

        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }

}
