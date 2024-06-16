package com.example.cs202pz.model;

public class TestModel {

    private int id;
    private String test;

    public TestModel(int id, String test) {
        this.id = id;
        this.test = test;
    }

    public TestModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", test='" + test + '\'' +
                '}';
    }
}
