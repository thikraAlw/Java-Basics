package org.example.dao;

import org.example.dto.EmployeeFilterDto;

import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {


    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\untitled\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_EMPLS = "select * from employees";
    private static final String SELECT_ONE_EMPL = "select * from employees where employee_id = ?";

    private static final String SELECT_ONE_EMPL_JOIN_JOB = "select * from employees join jobs on employees.job_id = jobs.job_id where employee_id = ?";

    private static final String SELECT_EMPL_WITH_JOB = "select * from employees where job_id = ?";
    private static final String SELECT_EMPL_WITH_JOB_PAGINATION = "select * from employees where job_id = ? order by employee_id limit ? offset ?";
    private static final String SELECT_EMPL_WITH_PAGINATION = "select * from employees order by employee_id limit ? offset ?";

    private static final String INSERT_EMPL = "insert into employees values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPL = "update employees set first_name = ?, last_name = ?, email = ? where employee_id = ?";
    private static final String DELETE_EMPL = "delete from employees where employee_id = ?";

    public void insertEmpl(Employee e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMPL);
        st.setInt(1, e.getEmployeeId());
        st.setString(2, e.getFirstName());
        st.setString(3, e.getLastName());
        st.setString(4, e.getEmail());
        st.setString(5, e.getPhone_number());
        st.setString(6, e.getHireDate());
        st.setInt(7, e.getJobId());
        st.setDouble(8, e.getSalary());
        st.setInt(9, e.getManager_id());
        st.setInt(10, e.getDepartmentId());
        st.executeUpdate();
    }

    public void updateEmpl(Employee e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMPL);
        st.setInt(4, e.getEmployeeId());
        st.setString(1, e.getFirstName());
        st.setString(2, e.getLastName());
        st.setString(3, e.getEmail());
        st.executeUpdate();
    }

    public void deleteEmpl(int emplId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMPL);
        st.setInt(1, emplId);
        st.executeUpdate();
    }

    public Employee selectEmpl(int emplId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPL_JOIN_JOB);
        st.setInt(1, emplId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employee(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Employee> selectAllEmpls(Integer jobId, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(jobId != null && limit != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_JOB_PAGINATION);
            st.setInt(1, jobId);
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(jobId != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_JOB);
            st.setInt(1, jobId);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_EMPLS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Employee> empls = new ArrayList<>();
        while (rs.next()) {
            empls.add(new Employee(rs));
        }

        return empls;
    }

    public ArrayList<Employee> selectAllEmpls(EmployeeFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getJobId() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_JOB_PAGINATION);
            st.setInt(1, filter.getJobId());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getJobId() != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_JOB);
            st.setInt(1, filter.getJobId());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_EMPL_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_EMPLS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Employee> empls = new ArrayList<>();
        while (rs.next()) {
            empls.add(new Employee(rs));
        }

        return empls;
    }
}
