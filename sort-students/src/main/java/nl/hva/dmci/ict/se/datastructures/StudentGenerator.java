/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.Random;
import model.Student;

/**
 *
 * @author Alexander van den Herik
 */
public class StudentGenerator {
    private int studentNumberStart= 50080001;
    private static final int NUMBER_OF_STUDENTS = 1000;
    private final Student[] studentArray = new Student[NUMBER_OF_STUDENTS];
    
    public Student[] studentGenerator(){
        String[] klassen = KlasGenerator.maakKlassen(NUMBER_OF_STUDENTS);
        for (int i = 0; i < studentArray.length; i++) {
            Student student = new Student();
            student.setStudentNumber(studentNumberStart++);
            student.setGrade(generateGrade());
            student.setKlas(klassen[i]);
            studentArray[i] = student;
        }
        return studentArray;
    } 
    
    public double generateGrade(){
        double start = 0.95;
        double end = 10.04;
        double random = new Random().nextDouble();
        double result = start + (random * (end - start));
        result = Math.round(result * 10);
        result = result / 10; 
        return result;
    }
    
}
