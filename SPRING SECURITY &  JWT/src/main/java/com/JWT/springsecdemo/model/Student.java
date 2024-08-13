package com.JWT.springsecdemo.model;

public class Student {

    private int id;
    private String name;
    private String tech;

    // No-argument constructor
    public Student() {
    }

    // All-argument constructor
    public Student(int id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
    }

    // Getters and setters
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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    // toString method
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", tech=" + tech + "]";
    }

    // equals and hashCode methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tech == null) ? 0 : tech.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tech == null) {
            if (other.tech != null)
                return false;
        } else if (!tech.equals(other.tech))
            return false;
        return true;
    }
}
