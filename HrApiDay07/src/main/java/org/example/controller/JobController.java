package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.JobDAO;
import org.example.dto.JobDto;
import org.example.dto.JobFilterDto;
import org.example.exceptions.DataNotFoundException;
import org.example.models.Job;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/jobs")
public class JobController {

    JobDAO dao = new JobDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllJobs(
            @BeanParam JobFilterDto filter
    ) {
        try {
            GenericEntity<ArrayList<Job>> jobs = new GenericEntity<ArrayList<Job>>(dao.selectAllJobs(filter)) {};
            if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(jobs)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }

            return Response
//                    .ok()
//                    .entity(jobs)
//                    .type(MediaType.APPLICATION_JSON)
                    .ok(jobs, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("{jobId}")
    public Response getJob(@PathParam("jobId") int jobId) throws SQLException {

        try {
            Job job = dao.selectJob(jobId);

            if (job == null) {
                throw new DataNotFoundException("Job " + jobId + "Not found");
            }

            JobDto dto = new JobDto();
            dto.setJobId(job.getJobId());
            dto.setJobTitle(job.getJobTitle());
            dto.setMaxSalary(job.getMaxSalary());
            dto.setMinSalary(job.getMinSalary());

            addLinks(dto);

            return Response.ok(dto).build();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void addLinks(JobDto dto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(EmployeeController.class)
                .build();

        dto.addLink(selfUri.toString(), "self");
        dto.addLink(empsUri.toString(), "employees");
    }


    @DELETE
    @Path("{jobId}")
    public void deleteJob(@PathParam("jobId") int jobId) {

        try {
            dao.deleteJob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response insertJob(Job job) {

        try {
            dao.insertJob(job);
            NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(job.getJobId() + "").build();
            return Response
//                    .status(Response.Status.CREATED)
                    .created(uri)
//                    .cookie(new NewCookie("username", "OOOOO"))
                    .cookie(cookie)
                    .header("Created by", "Wael")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
//    @Consumes(MediaType.APPLICATION_XML)
    public Response insertJobFromForm(@BeanParam Job job) {

        try {
            dao.insertJob(job);
            NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(job.getJobId() + "").build();
            return Response
//                    .status(Response.Status.CREATED)
                    .created(uri)
//                    .cookie(new NewCookie("username", "OOOOO"))
                    .cookie(cookie)
                    .header("Created by", "Wael")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")
    public void updateJob(@PathParam("jobId") int jobId, Job job) {

        try {
            job.setJobId(jobId);
            dao.updateJob(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Path("{jobId}/employees")
    public EmployeeController getEmployeeController() {
        return new EmployeeController();
    }


}
