package org.example.modes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {

    private int depId;
    private String depName;
    private int depLocation;

    public Department(int depId, String depName, int depLocation) {
        this.depId = depId;
        this.depName = depName;
        this.depLocation = depLocation;
    }

    public Department(ResultSet rs) throws SQLException {
        depId = rs.getInt("department_id");
        depName = rs.getString("department_Name");
        depLocation = rs.getInt("Location_id");
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getDepLocation() {
        return depLocation;
    }

    public void setDepLocation(int depLocation) {
        this.depLocation = depLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + depId +
                ", departmentName='" + depName + '\'' +
                ", locationId=" + depLocation +
                '}';

    }
}
