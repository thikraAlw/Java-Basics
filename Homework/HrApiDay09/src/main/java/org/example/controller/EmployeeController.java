package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.EmployeeDAO;
import org.example.dao.JobDAO;
import org.example.dto.EmployeeDto;
import org.example.dto.EmployeeFilterDto;
import org.example.exceptions.DataNotFoundException;
import org.example.mappers.EmployeeMapper;
import org.example.models.Employee;
import org.example.models.Job;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/employees")
public class EmployeeController {


    EmployeeDAO dao = new EmployeeDAO();
    JobDAO jDao = new JobDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "text/csv"})
    public Response getAllEmployees(@BeanParam EmployeeFilterDto filter) {
        try {
            GenericEntity<ArrayList<Employee>> empls = new GenericEntity<ArrayList<Employee>>(dao.selectAllEmpls(filter)) {};
            if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(empls)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            else if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf("text/csv"))) {
                return Response
                        .ok(empls)
                        .type("text/csv")
                        .build();
            }

            return Response
                    .ok(empls, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("{employeeId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "text/csv"})
    public Response getEmployee(@PathParam("employeeId") int employeeId) throws SQLException {

        try {
            Employee empl = dao.selectEmpl(employeeId);

            if (empl == null) {
                throw new DataNotFoundException("Employee " + employeeId + "Not found");
            }

//            Job j = jDao.selectJob(empl.getJobId());

//            EmployeeDto dto = EmployeeMapper.INSTANCE.toEmplDto(empl, job);

            EmployeeDto dto = EmployeeMapper.INSTANCE.toEmplDto(empl);

            addLinks(dto);

            return Response.ok(dto).build();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addLinks(EmployeeDto dto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(EmployeeController.class)
                .build();

        dto.addLink(selfUri.toString(), "self");
        dto.addLink(empsUri.toString(), "employees");
    }


    @DELETE
    @Path("{employeeId}")
    public void deleteEmployee(@PathParam("employeeId") int employeeId) {

        try {
            dao.deleteEmpl(employeeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response insertEmployee(EmployeeDto dto) {

        try {
            Employee empl = EmployeeMapper.INSTANCE.toModel(dto);
            dao.insertEmpl(empl);
            NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(empl.getEmployeeId() + "").build();
            return Response
                    .created(uri)
                    .cookie(cookie)
                    .header("Created by", "Wael")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @POST
    public Response insertEmployeeFromForm(@BeanParam Employee empl) {

        try {
            dao.insertEmpl(empl);
            NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(empl.getEmployeeId() + "").build();
            return Response
                    .created(uri)
                    .cookie(cookie)
                    .header("Created by", "Wael")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{employeeId}")
    public void updateEmployee(@PathParam("employeeId") int employeeId, Employee empl) {

        try {
            empl.setEmployeeId(employeeId);
            dao.updateEmpl(empl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Path("{employeeId}/jobs")
    public JobController getJobController() {
        return new JobController();
    }


}