package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudentRepository {

    HashMap<String,Student> studentDB = new HashMap<>();
    HashMap<String,Teacher> teacherDB = new HashMap<>();

    HashMap<String, ArrayList<Student>> teacherStudentDB = new HashMap<>();

    //add student into DB
    public void addStudent(Student student){
        studentDB.put(student.getName(),student);
    }

    //add teacher into DB
    public void addTeacher(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
    }

    //add teacher student pair in db
    public void addStudentTeacherPair(String studentName, String teacherName){

        if(!teacherStudentDB.containsKey(teacherName)){

            teacherStudentDB.put(teacherName, new ArrayList<Student>());
        }

        teacherStudentDB.get(teacherName).add(studentDB.get(studentName));

    }

    //get student by name
    public Student getStudentByName(String name){

        return studentDB.get(name);
    }

    //get teacher by name
    public Teacher getTeacherByName(String name){

        return teacherDB.get(name);
    }

    //get student by teacher name
    public List<String> getStudentsByTeacherName(String name){

        List<String> studentsName = new ArrayList<String>();

        for(Student student : teacherStudentDB.get(name)){
            studentsName.add(student.getName());
        }
    return studentsName; }


    //get all students
    public List<String> getAllStudents(){
        return new ArrayList<>(studentDB.keySet()); }

    //delete teacher and its student
    public void deleteTeacherByName (String name)throws NullPointerException{

        for(Student student : teacherStudentDB.get(name)){

            studentDB.remove(student);
        }

        teacherStudentDB.remove(name);
        teacherDB.remove(name);

    }

    // delete all student and teacher
    public void deleteAllTeachers() throws NullPointerException{

        for(String teacher : teacherDB.keySet()){

            for(Student student : teacherStudentDB.get(teacher)){

                studentDB.remove(student.getName());
            }
        }

        teacherDB.clear();
    }
}
