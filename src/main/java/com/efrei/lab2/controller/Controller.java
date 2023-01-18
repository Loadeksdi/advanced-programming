package com.efrei.lab2.controller;

import com.efrei.lab2.models.DBActions;
import com.efrei.lab2.utils.Constants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Controller extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Properties prop = new Properties();
        InputStream inputStream = getServletContext().getResourceAsStream(Constants.DB_PROPERTIES);
        prop.load(inputStream);

        String dbUrl = prop.getProperty("dbUrl");
        String dbUser = prop.getProperty("dbUser");
        String dbPwd = prop.getProperty("dbPwd");

        if (request.getParameter("action") == null) {
            request.getRequestDispatcher(Constants.JSP_HOME_PAGE).forward(request, response);
        } else {
            DBActions dbActions = new DBActions(dbUrl, dbUser, dbPwd);
            request.setAttribute("empList", dbActions.getEmployees());
            request.getRequestDispatcher(Constants.JSP_EMPLOYEES_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
