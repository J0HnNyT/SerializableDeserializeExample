/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializabledeserializeexample;

import java.io.Serializable;

/**
 *
 * @author johntaylor
 */
public class Student implements Serializable{
    
    private String name;
    private double GPA;
    
    Student(){
        this.name = "";
        this.GPA = 0.0;
    }
    
    Student(String studentName, double gpa){
        this.name = studentName;
        this.GPA = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    @Override
    public String toString(){
        return String.format("Student Name: " + this.name + "\nGPA: " + GPA);
    }
    
}//End student class.
