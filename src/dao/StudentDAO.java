package dao;

import entity.Student;

import java.util.List;

public interface StudentDAO {

    void create(Student student);

    boolean delete(Student student);

    List<Student> getStudentsByGroupId(Integer groupId);

}
