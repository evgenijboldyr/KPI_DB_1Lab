package entity;

import java.util.List;

public class Group {

    private Integer id;
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name;
    }
}
