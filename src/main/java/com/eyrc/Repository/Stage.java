package com.eyrc.Repository;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    @OneToMany
    private List<Task> taskList = new ArrayList<Task>();

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", number=" + number +
                ", taskList=" + taskList +
                '}';
    }
}
