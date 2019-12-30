/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssms.dal.dao;

import java.util.List;

import ssms.entity.Student;


/**
 *
 * @author apple
 */
public interface StudentDao 
{
    public boolean addStudent(Student stu);
    
    public boolean updateStudent(Student stu);
    
    public boolean delStudentbyID(String id);
    
    public Student getStudentbyID(String id);
    
    public List<Student> getStudentbyName(String name);
    
    public List<Student> getAllStudent();
    
    public List<Student> getAllStudentByIdAndNameAndClass(String id, String name, String className);
    
 }
