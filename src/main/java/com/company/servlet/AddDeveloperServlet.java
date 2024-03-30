package com.company.servlet;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-developer")
public class AddDeveloperServlet extends HttpServlet {

    @EJB
    private DeveloperDAO developerDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String experience = req.getParameter("experience");
        String position = req.getParameter("position");
        String mainTechnology = req.getParameter("mainTechnology");
        double salary = Double.valueOf(req.getParameter("salary"));

        Developer developer = new Developer(name, experience, position, mainTechnology, salary);
        developerDAO.add(developer);

        resp.sendRedirect(getServletContext().getContextPath() + "/home");
    }
}
