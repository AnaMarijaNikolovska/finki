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

@WebServlet(name = "student_servlet", urlPatterns ="/AddStudent")
public class ListStudentServlet extends HttpServlet {
    private final StudentService studentService;

    public ListStudentServlet(StudentService studentService) {
        this.studentService = studentService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.listAll();
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Add new Student to Course</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<header>");
        writer.println("<h1>Student Enrollment - Select the Student </h1>");
        writer.println("</header>");
        writer.println("<section>");
        writer.println("<h2>Select the student to enroll:</h2>");
        writer.println("<a href='/createStudent' type='button'>Create New Student</a> <br/> <br/>");
        writer.println("<ul>");
        students.forEach(r->
                writer.format("<li><input type='radio' value='%s.%s' name='size'/>" +
                        "<label> %s %s </label></li>",r.getName().toLowerCase(),r.getSurname().toLowerCase(), r.getName(), r.getSurname()));

        writer.println("<ul>");
        writer.println("<br/>");
        writer.println("<a href='/StudentEnrollmentSummary'>Submit</a>");
        writer.println("</section>");
        writer.println("<aside>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th colspan='2'>Your Enrollment Status" + "</th>");
        writer.println("</tr>");
        writer.println("<tr>" + "<td><b>Course Id</b></td>" + "<td>2</td>" + "</tr>");
        writer.println("</table>");
        writer.println("</aside>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }

}
