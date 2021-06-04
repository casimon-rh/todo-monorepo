package com.redhat.todo.back.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.redhat.todo.back.entity.Task;

/**
 * TodoService
 */
@ApplicationScoped
public class TodoService {
  @Inject
  EntityManager em;

  @Transactional
  public void createTask(String description) {
    Task task = new Task();
    task.setDescription(description);
    em.persist(task);
  }

  public List<Task> getTasks() {
    CriteriaQuery<Task> cq = em.getCriteriaBuilder().createQuery(Task.class);
    Root<Task> rootEntry = cq.from(Task.class);
    return em.createQuery(cq.select(rootEntry)).getResultList();
  }

  @Transactional
  public void deleteTask(Long id) {
    Task task = em.find(Task.class, id);
    em.remove(task);
  }

  @Transactional
  public void markDone(Long id) {
    Task task = em.find(Task.class, id);
    task.setDone(true);
  }
  @Transactional
  public void markUnDone(Long id) {
    Task task = em.find(Task.class, id);
    task.setDone(false);
  }
}