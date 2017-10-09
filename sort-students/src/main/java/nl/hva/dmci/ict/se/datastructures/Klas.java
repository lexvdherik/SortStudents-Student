/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.ArrayList;
import model.Student;

/**
 *
 * @author alwin
 */
public class Klas {
    private final int MAX_SIZE = 32;
    private ArrayList<Student> studentList;
    private String classId;
    private int size;

    public Klas(String classId) {
        this.classId = classId;
        studentList = new ArrayList();
    }

    public void addStudent(Student s) {
        if (studentList.size() < MAX_SIZE) {
            studentList.add(s);
//            s.setKlasNummer(classId);
            size++;
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public String getClassId() {
        return classId;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Klas{" + "MAX_SIZE=" + MAX_SIZE + ", classId=" + classId + ", size=" + size + '}';
    }

//    @Override
//    public int compareTo(Klas k) {
//        return classId.compareTo(k.getClassId());
//    }
}
