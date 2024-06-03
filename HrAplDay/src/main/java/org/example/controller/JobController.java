package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.JobDAO;
import org.example.modes.Department;
import org.example.modes.Job;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/departments")
public class JobController {

    JobDAO dao = new JobDAO();

    @GET
    public  ArrayList<Job> getAllJobs() {
        try {
            return dao.selectAllJobs();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("{jobId}")
    public Job getJob(@PathParam("jobId") int jobId) {

        try {
            return dao.selectJob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    public void insertJob(Job j) {

        try {
            dao.insertJob(j);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")
    public void updateJob(@PathParam("jobId") int jobId, Job j) {

        try {
            j.setJobId(jobId);
            dao.updateJob(j);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    }

