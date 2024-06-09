package org.example.models;

import jakarta.ws.rs.FormParam;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;

@XmlRootElement
public class Job {

    @FormParam("jobId")
    private int jobId;
    @FormParam("jobTitle")
    private String jobTitle;
    @FormParam("minSalary")
    private double minSalary;
    @FormParam("maxSalary")
    private double maxSalary;

    public Job() {
    }

    public Job(int jobId, String jobTitle, double minSalary, double maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Job(ResultSet rs) throws SQLException {
        jobId = rs.getInt("job_id");
        jobTitle = rs.getString("job_title");
        minSalary = rs.getDouble("min_salary");
        maxSalary = rs.getDouble("max_salary");
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary+
                ", maxSalary=" + maxSalary+
                '}';
    }
}