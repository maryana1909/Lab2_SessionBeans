package com.company.servlet;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/remove-developer")
public class RemoveDeveloperServlet extends HttpServlet {
    @EJB
    private DeveloperDAO developerDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("developer-id");
        Optional<Developer> developerOptional = developerDAO.get(name);
        developerOptional.ifPresent(developerDAO::remove);
        resp.sendRedirect(getServletContext().getContextPath() + "/home");
    }
}
