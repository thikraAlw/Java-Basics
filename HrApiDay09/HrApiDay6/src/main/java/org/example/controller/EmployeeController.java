package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.example.helpers.EmployeeIdConverterProvider;
import org.example.models.Department;
import org.example.models.Employee;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/employees")
public class EmployeeController {


//EmployeeDao dao = new EmployeeDao();

    @GET
    public ArrayList<Employee> getAllEmployees(@PathParam("deptId") Integer deptId) {
        System.out.println(deptId);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        return employees;
    }

//    @GET
//    @Path("{employee_id}")
//    public Employee SELECT_ONE_EMPLOYEE(@PathParam("employee_id") int employee_id) {
//
////        try {
//////            return dao.selectEmployees(employee_id);
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//    }
//
//    @DELETE
//    @Path("{employee_id}")
//    public void DELETE_JOB(@PathParam("employee_id") int employee_id) {
//
//        try {
////            dao.deleteEmployees(employee_id);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }




}
