package com.redhat.todo.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Task {
  private Long id;
  private String description;
  private boolean done;

  @Id
  @SequenceGenerator(name = "taskSeq", sequenceName = "task_id_seq", allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "taskSeq")
  public Long getId() {
    return id;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
