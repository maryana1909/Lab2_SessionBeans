package com.company.servlet;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;
import com.company.service.find.DeveloperFindService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find-developer")
public class FindDeveloperServlet extends HttpServlet {
    @EJB
    private DeveloperFindService developerFindService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("reset") != null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/home");

        } else {
            List<Developer> developerList = developerFindService.find();
            req.setAttribute("developerList", developerList);
            getServletContext().getRequestDispatcher("/home").forward(req, resp);
        }
    }
}
