package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class JobFilterDto {

    private @QueryParam("maxSalary") Double maxSalary;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
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
