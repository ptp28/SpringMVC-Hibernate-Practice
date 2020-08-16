package com.eyrc.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theme
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    List<Stage> stageList = new ArrayList<Stage>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Stage> getStageList() {
        return stageList;
    }
    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stageList=" + stageList +
                '}';
    }
}

