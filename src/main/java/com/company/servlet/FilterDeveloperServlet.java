package com.company.servlet;

import com.company.entity.Developer;
import com.company.service.filter.DeveloperFilterService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter-developer")
public class FilterDeveloperServlet extends HttpServlet {
    @EJB
    private DeveloperFilterService developerFilterService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("reset") != null)
            resp.sendRedirect(getServletContext().getContextPath() + "/home");
        else {
            String position = req.getParameter("developer-id");
            List<Developer> developerList = developerFilterService.filter(position);
            req.setAttribute("developerList", developerList);
            getServletContext().getRequestDispatcher("/home").forward(req, resp);
        }
    }
}
