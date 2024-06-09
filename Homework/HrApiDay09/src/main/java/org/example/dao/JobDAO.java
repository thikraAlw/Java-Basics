package org.example.dao;

import org.example.dto.JobFilterDto;
import org.example.models.Job;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\untitled\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_JOBS = "select * from jobs";
    private static final String SELECT_ONE_JOB = "select * from jobs where job_id = ?";

    private static final String SELECT_JOB_WITH_MS = "select * from jobs where max_salary = ?";
    private static final String SELECT_JOB_WITH_MS_PAGINATION = "select * from jobs where max_salary = ? order by job_id limit ? offset ?";
    private static final String SELECT_JOB_WITH_PAGINATION = "select * from jobs order by job_id limit ? offset ?";

    private static final String INSERT_JOB = "insert into jobs values (?, ?, ?, ?)";
    private static final String UPDATE_JOB = "update jobs set jobs_title = ?, mis_salary = ?, max_salary = ?, where job_id = ?";
    private static final String DELETE_JOB = "delete from jobs where job_id = ?";

    public void insertJob(Job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOB);
        st.setInt(1, j.getJobId());
        st.setString(2, j.getJobTitle());
        st.setDouble(3, j.getMinSalary());
        st.setDouble(4, j.getMaxSalary());
        st.executeUpdate();
    }

    public void updateJob(Job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOB);
        st.setInt(1, j.getJobId());
        st.setString(2, j.getJobTitle());
        st.setDouble(3, j.getMinSalary());
        st.setDouble(4, j.getMaxSalary());
        st.executeUpdate();
    }

    public void deleteJob(int jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOB);
        st.setInt(1, jobId);
        st.executeUpdate();
    }

    public Job selectJob(int jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOB);
        st.setInt(1, jobId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Job(rs);
        }
        else {
            return null;
        }
    }


    public ArrayList<Job> selectAllJobs(Double maxSalary, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(maxSalary != null && limit != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MS_PAGINATION);
            st.setDouble(1, maxSalary);
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(maxSalary != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MS);
            st.setDouble(1, maxSalary);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(rs));
        }

        return jobs;
    }


    public ArrayList<Job> selectAllJobs(JobFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getMaxSalary() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MS_PAGINATION);
            st.setDouble(1, filter.getMaxSalary());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getMaxSalary() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MS);
            st.setDouble(1, filter.getMaxSalary());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(rs));
        }

        return jobs;
    }

}