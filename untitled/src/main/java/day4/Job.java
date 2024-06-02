package day4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Job {

    private int jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;

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
