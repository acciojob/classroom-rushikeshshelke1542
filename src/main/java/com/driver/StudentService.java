package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    //add student
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    //add Teacher
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    //student teacher pair
    public void addStudentTeacherPair(String studentName, String teacherName) {

        studentRepository.addStudentTeacherPair(studentName,teacherName);
    }

    //get student by name
    public Student getStudentByName(String name){

        return studentRepository.getStudentByName(name);
    }

    //get Teacher by name
    public Teacher getTeacherByName(String name){

        return studentRepository.getTeacherByName(name);
    }

    //get Student by teacher name
    public List<String> getStudentsByTeacherName(String name){

        return studentRepository.getStudentsByTeacherName(name);
    }

    //get all student
    public List<String> getAllStudents(){

        return studentRepository.getAllStudents();
    }

    //delete teacher and associated student
    public void deleteTeacherByName(String teacher){

        studentRepository.deleteTeacherByName(teacher);
    }

    //delete all teacher
    public void deleteAllTeachers(){

        studentRepository.deleteAllTeachers();
    }

}
