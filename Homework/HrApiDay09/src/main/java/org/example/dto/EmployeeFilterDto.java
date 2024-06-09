package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class EmployeeFilterDto {

    private @QueryParam("jobId") Integer jobId;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}

