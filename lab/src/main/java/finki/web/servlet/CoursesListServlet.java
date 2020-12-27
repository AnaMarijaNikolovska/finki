package finki.web.servlet;

import finki.model.Course;
import finki.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "category_servlet", urlPatterns = "/listCourses")
public class CoursesListServlet extends HttpServlet {
    private final CourseService courseService;

    public CoursesListServlet(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = courseService.listAll();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Welcome and Choose a Course</title>");
        writer.println("<style type='text/css'> body { width: 800px; margin: auto;} </style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<header>");
        writer.println("<h1>Courses List</h1>");
        writer.println("</header>");
        writer.println("<main>");
        writer.println("<h2>Choose course:</h2>");
        writer.println("<ul>");
        courses.forEach(r->
                writer.format("<li><input type='radio' value='%s' name='courseId'/>" +
                        "<label> %s </label></li>",r.getId(),r.getName()));

        writer.println("<ul>");
        writer.println("<br/>");
        writer.println("<a href='/АddStudent'>Submit</a>");
        writer.println("</main>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
