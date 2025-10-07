package org.ex.ch14_email_java;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@WebServlet(name = "EmailListServlet", value = "/EmailListServlet")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        String url = "/index.jsp";
        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            //store data in User obj
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            UserDB.insert(user);
            request.setAttribute("user", user);

            String to = email;
            String from = "23133014@student.hcmute.edu.vn";
            String subject = "Welcome to our email list";
            String body = "Dear " + firstName + ",\n\n"
                    + "Thanks for joining our email list. We'll make sure to send "
                    + "you announcements about new products and promotions.\n"
                    + "Have a great day and thanks again!\n\n"
                    + "Best regards,\n"
                    + "UTE Student Support Team";
            boolean isBodyHTML = false;

            try {
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
            } catch (MessagingException e) {
                String errorMessage = "ERROR: Unable to send email. "
                        + "Check Tomcat logs for details.<br>"
                        + "NOTE: You may need to configure your system "
                        + "as described in chapter 14.<br>"
                        + "ERROR MESSAGE: " + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                        "Unable to send email. \n"
                                + "Here is the email you tried to send: \n"
                                + "==================================== \n"
                                + "TO: " + email + "\n"
                                + "FROM: " + from + "\n"
                                + "SUBJECT: " + subject + "\n"
                                + "\n"
                                + body + "\n\n");
            }
            url = "/thanks.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
