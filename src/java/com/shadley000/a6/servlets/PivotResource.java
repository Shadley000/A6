/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.servlets;

import com.shadley000.a6.beans.PivotParametersBean;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
@Path("/pivot")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PivotResource {

    //@QueryParam("startdate") String startDate, @QueryParam("enddate") String endDate) {
    @GET
    public JSONObject getIt(){//@PathParam("id") int id, PivotParametersBean params) {

        JSONObject result = new JSONObject();
        result.put("PivotResource", "dummyvalue");
        result.put("id", 0);
        //result.put("startdate", params.getStartDate());
        //result.put("enddate", params.getEndDate());

        return result;
    }
}
