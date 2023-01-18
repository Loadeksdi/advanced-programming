package com.efrei.lab2.models;

import java.sql.*;
import java.util.ArrayList;

import static com.efrei.lab2.utils.Constants.QUERY_SEL_EMPLOYEES;

public class DBActions {
    private Connection conn;
    public DBActions(String dbUrl, String dbUser, String dbPwd) {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException sqle) {
            // SQLException contains more data about the reason of the error,
            // and we want our code to manage only these errors for the moment
            System.err.println(sqle.getErrorCode() + " " + sqle.getMessage());
        }
    }

    public Statement getStatement() {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            // Connection is replaced by an implementation at runtime
        } catch (SQLException sqle) {
            System.err.println(sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return stmt;
    }

    public ResultSet getResultSet(String query) {
        Statement stmt = getStatement();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException sqle) {
            System.err.println(sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return rs;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> listEmployees = new ArrayList<>();
        ResultSet rs = getResultSet(QUERY_SEL_EMPLOYEES);
        try {
            while (rs.next()) {
                Employee employeeBean = new Employee();
                employeeBean.setId(String.valueOf(rs.getInt("id")));
                employeeBean.setFirstname(rs.getString("FIRSTNAME"));
                employeeBean.setName(rs.getString("LASTNAME"));
                employeeBean.setMail(rs.getString("EMAIL"));
                employeeBean.setCity(rs.getString("CITY"));
                employeeBean.setAddress(rs.getString("ADDRESS"));
                employeeBean.setPostalCode(rs.getString("POSTALCODE"));
                employeeBean.setHomePhone(rs.getString("HOMEPHONE"));
                employeeBean.setMobilePhone(rs.getString("MOBILEPHONE"));
                employeeBean.setProPhone(rs.getString("WORKPHONE"));
                listEmployees.add(employeeBean);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return listEmployees;
    }
}
