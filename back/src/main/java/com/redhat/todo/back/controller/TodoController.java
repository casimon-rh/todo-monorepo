package com.redhat.todo.back.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.todo.back.entity.Task;
import com.redhat.todo.back.service.TodoService;

@Path("/todo")
public class TodoController {

  @Inject
  TodoService service;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Task> getTasks() {
    return service.getTasks();
  }

  @POST
  @Path("/new")
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public void createTask(String description) {
    service.createTask(description);
  }

  @DELETE
  @Path("/del/{id}")
  public void deleteTask(@PathParam("id") Long id) {
    service.deleteTask(id);
  }

  @POST
  @Path("/done/{id}")
  public void doneTask(@PathParam("id") Long id) {
    service.markDone(id);
  }
  @POST
  @Path("/undone/{id}")
  public void unDoneTask(@PathParam("id") Long id) {
    service.markUnDone(id);
  }
}
