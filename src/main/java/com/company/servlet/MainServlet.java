package com.company.servlet;

import com.company.dao.DeveloperDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class MainServlet extends HttpServlet {
    @EJB
    private DeveloperDAO developerDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("developerList", this.developerDAO.getAll());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getAttribute("developerList") == null) {
            req.setAttribute("developerList", this.developerDAO.getAll());
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
