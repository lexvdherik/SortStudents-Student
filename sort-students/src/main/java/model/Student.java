/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alexander van den Herik
 */
public class Student implements Comparable<Student> {

    private int studentNumber;
    private double grade;
    private String klas;

    public Student(int studentNumber, int grade, String klas) {
        this.studentNumber = studentNumber;
        this.grade = grade;
        this.klas = klas;
    }

    public Student() {
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    @Override
    public String toString() {
        return "Student{" + "studentNumber=" + studentNumber + ", grade=" + grade + ", klas=" + klas + '}';
    }

    @Override
    public int compareTo(Student student) {
        if (this.grade < student.getGrade()) {
            return -1;
        } else if (this.grade == student.getGrade()) {
            if (this.studentNumber > student.getStudentNumber()) {
                return 1;
            }
            return 0;
        } else {
            return 1;
        }
    }
    
    public int compareToStudentNr(Student student) {
        if (this.studentNumber < student.getStudentNumber()) {
            return -1;
        } else {
            return 1;
        }
    }

}
